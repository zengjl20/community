package life.jielin.community.community.controller;

import life.jielin.community.community.dto.CommentCreateDTO;
import life.jielin.community.community.dto.CommentDTO;
import life.jielin.community.community.dto.ResultDTO;
import life.jielin.community.community.enums.CommentTypeEnum;
import life.jielin.community.community.exception.CustomizeErrorCode;
import life.jielin.community.community.exception.CustomizeException;
import life.jielin.community.community.model.Comment;
import life.jielin.community.community.model.User;
import life.jielin.community.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if (commentCreateDTO.getContent() == null || commentCreateDTO.getContent().equals("")) {
            throw new CustomizeException(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreated(System.currentTimeMillis());
        comment.setCommentator(user.getAccountId());
        comment.setLikeCount(0);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.POST)
    public ResultDTO<List> comments(@PathVariable(name = "id") Long id){
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }
}

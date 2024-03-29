package life.jielin.community.community.controller;

import life.jielin.community.community.dto.CommentDTO;
import life.jielin.community.community.dto.QuestionDTO;
import life.jielin.community.community.enums.CommentTypeEnum;
import life.jielin.community.community.service.CommentService;
import life.jielin.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(HttpServletRequest request,
                           HttpServletResponse response,
                           Model model,
                           @PathVariable(name = "id") String id){
        Long questionId = null;
        questionId = Long.parseLong(id);
        QuestionDTO questionDTO = questionService.getById(questionId);
        questionService.incView(questionDTO.getId());
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        List<CommentDTO> commentDTOList = commentService.listByTargetId(questionId, CommentTypeEnum.QUESTION);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", commentDTOList);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }
}

package life.jielin.community.community.controller;

import life.jielin.community.community.mapper.QuestionMapper;
import life.jielin.community.community.mapper.UserMapper;
import life.jielin.community.community.model.Question;
import life.jielin.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPulish(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "tag") String tag,
            @RequestParam(name = "description") String description,
            HttpServletRequest request,
            Model model){
        model.addAttribute("title", title);
        model.addAttribute("tag", tag);
        model.addAttribute("description", description);

        if (title == null || title.equals("")){
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description == null || description.equals("")){
            model.addAttribute("error", "问题描述不能为空");
            return "publish";
        }
        if (tag == null || tag.equals("")){
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        User user = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                user = userMapper.findByToken(token);
                if(user != null){
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        questionMapper.create(question);
        return "redirect:/";
    }
}

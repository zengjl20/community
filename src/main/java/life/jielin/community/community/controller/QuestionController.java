package life.jielin.community.community.controller;

import life.jielin.community.community.dto.QuestionDTO;
import life.jielin.community.community.mapper.QuestionMapper;
import life.jielin.community.community.model.User;
import life.jielin.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(HttpServletRequest request,
                           Model model,
                           @PathVariable(name = "id") String id){
        User user = (User) request.getSession().getAttribute("user");
        /*if(user == null){
            return "redirect:/";
        }
         */
        Integer questionId = null;
        questionId = Integer.parseInt(id);
        QuestionDTO questionDTO = questionService.getById(questionId);
        questionService.incView(questionDTO.getId());
        model.addAttribute("question", questionDTO);
        return "question";
    }
}

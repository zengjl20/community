package life.jielin.community.community;

import life.jielin.community.community.dto.QuestionDTO;
import life.jielin.community.community.mapper.QuestionExtMapper;
import life.jielin.community.community.model.Question;
import life.jielin.community.community.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class UpdateViewCountTests {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Test
    public void testViewCount() {
        Long questionId = null;
        questionId = Long.parseLong("32");
        QuestionDTO questionDTO = questionService.getById(questionId);
        for(int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Integer curCount = questionDTO.getViewCount() + 1;
                    Question question = new Question();
                    question.setId(questionDTO.getId());
                    question.setViewCount(curCount);
                    questionExtMapper.incViewTest(question);
                }
            }
            ).start();
        }
    }
}

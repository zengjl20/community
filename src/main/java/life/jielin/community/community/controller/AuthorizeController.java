package life.jielin.community.community.controller;

import life.jielin.community.community.dto.AccessTokenDTO;
import life.jielin.community.community.dto.GithubUser;
import life.jielin.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("Iv1.1f20f4cc25973703");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_secret("8cb6f3b7c1ed316c11bcf3597366ff31c3fc27f2");
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = GithubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}

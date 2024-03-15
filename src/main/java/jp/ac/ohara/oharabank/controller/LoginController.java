package jp.ac.ohara.oharabank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LoginController{
	@RequestMapping(path="/")
	   public String showLogin(@RequestParam(required = false) String error) {
        System.err.println("login error:" + error);
        if (error != null) {
            System.err.println("ログインに失敗しました。");
        }
        return "login";
    }
}
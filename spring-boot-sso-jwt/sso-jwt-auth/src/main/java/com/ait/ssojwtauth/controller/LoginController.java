package com.ait.ssojwtauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ait.ssojwtauth.utills.CookieUtil;
import com.ait.ssojwtauth.utills.JwtUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*
 * Aloke Das
 */
@Controller
public class LoginController {
    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";
    private static final Map<String, String> credentials = new HashMap<>();

    public LoginController() {
        credentials.put("hellokoding", "hellokoding");
        credentials.put("hellosso", "hellosso");
    }

    @GetMapping("/")
    public String home(){
    	//System.out.println("Auth server>>>>>>>>default home called");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
    	//System.out.println("Auth server>>>>>>>>login called:");
        return "login";
    }

    @PostMapping("login")
    public String login(HttpServletResponse httpServletResponse, String username, String password, String redirect, Model model){
        if (username == null || !credentials.containsKey(username) || !credentials.get(username).equals(password)){
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
        //System.out.println("auth-service>>>>>>>>>>>redirect:"+redirect);
        String token = JwtUtil.generateToken(signingKey, username);
        //System.out.println("aut-service>>>>>>>>>>>token:"+token);
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");
        return "redirect:" + redirect;
    }
}

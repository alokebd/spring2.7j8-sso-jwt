package com.ait.ssojwtresource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.ait.ssojwtresource.utils.CookieUtil;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ResourceController {
    private static final String jwtTokenCookieName = "JWT-TOKEN";

    @GetMapping("/")
    public String home() {
        return "redirect:/protected-resource";
    }

    @GetMapping("/protected-resource")
    public String protectedResource() {
        return "protected-resource";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse) {
        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
        return "redirect:/";
    }
}
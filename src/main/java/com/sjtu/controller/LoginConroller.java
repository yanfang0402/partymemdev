package com.sjtu.controller;

import com.sjtu.pojo.Member;
import com.sjtu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
public class LoginConroller {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/user/login")
    public String loginMember(@PathVariable("mId") String mId, @PathVariable("mPassword") String mPassword,
                              HttpSession session, RedirectAttributes redirectAttributes) {
        Member member = memberService.selectMemeberByIdAndPassword(mId, mPassword);
        if (member != null) {
            session.setAttribute("loginMember", member);
            return "redirect:/main";
        } else {
            redirectAttributes.addFlashAttribute("loginMsg", "登录失败，学号不存在或密码错误");
            return "redirect:/index";
        }
    }
}

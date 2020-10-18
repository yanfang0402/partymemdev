package com.sjtu.controller;

import com.sjtu.pojo.Member;
import com.sjtu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
public class LoginConroller {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/user/login")
    public String loginMember(String mId, String mPassword,
                              HttpSession session, RedirectAttributes redirectAttributes) {
        Member member = memberService.selectMemeberByIdAndPassword(mId, mPassword);
        if (member != null) {
            session.setAttribute("loginMember", member);
            return "redirect:/main";
        } else {
            redirectAttributes.addFlashAttribute("loginMsg", "登录失败，学号不存在或密码错误");
            redirectAttributes.addFlashAttribute("mId", mId);
            redirectAttributes.addFlashAttribute("tag", "here");
            return "redirect:/index";
        }
    }

    @RequestMapping("/user/logout")
    public String logoutMember(HttpSession session, RedirectAttributes redirectAttributes) {
        session.removeAttribute("loginMember");
        redirectAttributes.addFlashAttribute("loginMsg", "注销成功");
        return "redirect:/index";
    }
}

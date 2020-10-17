package com.sjtu.controller;

import com.sjtu.pojo.Member;
import com.sjtu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class RegisterController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/toRegisterMemberPage")
    public String toRegisterMemberPage() {
        return "register";
    }

    @RequestMapping("/user/register")
    public String registerMember(Member member, String mPasswordConfirm, RedirectAttributes redirectAttributes, Model model) {
        if (!mPasswordConfirm.equals(member.getMPassword())) {
            model.addAttribute("registerMsg", "注册失败，两次输入的密码不一致，请重试");
            model.addAttribute("member", member);
            model.addAttribute("tag", "here");
            return "register";
        }
        try {
            int result = memberService.insertMember(member);
            redirectAttributes.addFlashAttribute("registerMsg", "注册成功，请登录");
            return "redirect:/index";
        } catch (Exception e) {
            model.addAttribute("registerMsg", "注册失败，该学号已注册，请重试");
            model.addAttribute("member", member);
            model.addAttribute("tag", "here");
            return "register";
        }
    }

}

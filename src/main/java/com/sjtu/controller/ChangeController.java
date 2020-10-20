package com.sjtu.controller;

import com.sjtu.pojo.Member;
import com.sjtu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ChangeController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/user/changeMemberPassword")
    public String changeMemberPassword(String mPassword, String mNewPassword, String mNewPasswordConfirm,
                                       HttpSession session, RedirectAttributes redirectAttributes) {
        if (!mNewPassword.equals(mNewPasswordConfirm)) {
            redirectAttributes.addFlashAttribute("changeMsg", "修改密码失败，两次输入的新密码不一致，请重试");
            return "redirect:/changeMemberPassword";
        }
        Member member = (Member) session.getAttribute("loginMember");
        if (!mPassword.equals(member.getMPassword())) {
            redirectAttributes.addFlashAttribute("changeMsg", "修改密码失败，旧密码错误，请重试");
            return "redirect:/changeMemberPassword";
        }
        try {
            member.setMPassword(mNewPassword);
            int result = memberService.updateMember(member);
            redirectAttributes.addFlashAttribute("changeMsg", "修改密码成功，请重新登录");
            session.removeAttribute("loginMember");
            return "redirect:/index";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("changeMsg", "修改密码失败，未知错误，请重试");
            return "redirect:/changeMemberPassword";
        }
    }
}

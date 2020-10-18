package com.sjtu.controller;

import com.sjtu.pojo.Member;
import com.sjtu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String registerMember(Member member, String mPasswordConfirm, RedirectAttributes redirectAttributes) {
        if (!mPasswordConfirm.equals(member.getMPassword())) {
            redirectAttributes.addFlashAttribute("registerMsg", "注册失败，两次输入的密码不一致，请重试");
            returnRegisterInformation(member, redirectAttributes);
            return "redirect:/register";
        }
        try {
            int result = memberService.insertMember(member);
            redirectAttributes.addFlashAttribute("registerMsg", "注册成功，请登录");
            return "redirect:/index";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("registerMsg", "注册失败，该学号已注册，请重试");
            returnRegisterInformation(member, redirectAttributes);
            return "redirect:/register";
        }
    }

    private void returnRegisterInformation(Member member, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mId", member.getMId());
        redirectAttributes.addFlashAttribute("mName", member.getMName());
        redirectAttributes.addFlashAttribute("mClass", member.getMClass());
        redirectAttributes.addFlashAttribute("mGender", member.getMGender());
        redirectAttributes.addFlashAttribute("mNation", member.getMNation());
        redirectAttributes.addFlashAttribute("mNativePlace", member.getMNativePlace());
        redirectAttributes.addFlashAttribute("mAdmissionTime", member.getMAdmissionTime());
        redirectAttributes.addFlashAttribute("mIdCard", member.getMIdCard());
        redirectAttributes.addFlashAttribute("mPhone", member.getMPhone());
        redirectAttributes.addFlashAttribute("mPlace", member.getMPlace());
        redirectAttributes.addFlashAttribute("mFamilyPlace", member.getMFamilyPlace());
    }

}

package com.sjtu;

import com.sjtu.pojo.*;
import com.sjtu.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Controller
class PartymemdevApplicationTests {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private ControllerService controllerService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private PartyService partyService;


    @Test
    void testInsertMember() {
        try {
            int a = memberService.insertMember(
                    new Member(
                            "2016000201010", "@87v5zrp",
                            0, "张睿鹏", "英才班",
                            "男", "汉族", "河北省清苑县",
                            new Date(), "130603199801080314", "18331170418",
                            "上海市闵行区", "河北省保定市"));
            System.out.println("插入成功");
        } catch (Exception e) {
            System.out.println("插入失败");
        }
    }

    @Test
    void testSelectMemeberByIdAndPassword() {
        Member member = memberService.selectMemeberByIdAndPassword("2016000201010", "@87v5zrp");
        if (member == null) {
            System.out.println("登录失败");
        } else {
            System.out.println("登陆成功");
        }
    }

    @Test
    void testSelectAllParty() {
        List<Party> partyList = partyService.selectAllParty();
        System.out.println(partyList.size());
    }
}

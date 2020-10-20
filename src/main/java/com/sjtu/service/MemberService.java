package com.sjtu.service;

import com.sjtu.pojo.Member;

public interface MemberService {

    //注册，插入成员信息
    int insertMember(Member member) throws Exception;

    //登录，查询对应成员信息
    Member selectMemeberByIdAndPassword(String mId, String mPassword);

    //修改密码，更新对应成员信息
    int updateMember(Member member) throws Exception;
}

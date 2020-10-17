package com.sjtu.dao;

import com.sjtu.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
@Repository
public interface MemberMapper {

    //注册，插入成员信息
    int insertMember(Member member) throws Exception;

    //登录，查询对应成员信息
    Member selectMemeberByIdAndPassword(@PathVariable("mId") String mId, @PathVariable("mPassword") String mPassword);

}

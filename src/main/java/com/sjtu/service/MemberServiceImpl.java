package com.sjtu.service;

import com.sjtu.dao.MemberMapper;
import com.sjtu.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public int insertMember(Member member) throws Exception {
        return memberMapper.insertMember(member);
    }

    @Override
    public Member selectMemeberByIdAndPassword(String mId, String mPassword) {
        return memberMapper.selectMemeberByIdAndPassword(mId, mPassword);
    }

    @Override
    public int updateMember(Member member) throws Exception {
        return memberMapper.updateMember(member);
    }
}

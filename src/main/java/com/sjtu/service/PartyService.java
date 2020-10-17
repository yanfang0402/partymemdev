package com.sjtu.service;

import com.sjtu.pojo.Party;

import java.util.List;

public interface PartyService {

    //查询全部党组织信息
    List<Party> selectAllParty();

}

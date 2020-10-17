package com.sjtu.service;

import com.sjtu.dao.PartyMapper;
import com.sjtu.pojo.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyServiceImpl implements PartyService{

    @Autowired
    private PartyMapper partyMapper;

    public void setPartyMapper(PartyMapper partyMapper) {
        this.partyMapper = partyMapper;
    }

    @Override
    public List<Party> selectAllParty() {
        return partyMapper.selectAllParty();
    }
}

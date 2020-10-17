package com.sjtu.dao;

import com.sjtu.pojo.Party;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface PartyMapper {

    //查询全部党组织信息
    List<Party> selectAllParty();

}

package com.sjtu.service;

import com.sjtu.dao.ControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControllerServiceImpl implements ControllerService{

    @Autowired
    private ControllerMapper controllerMapper;

    public void setControllerMapper(ControllerMapper controllerMapper) {
        this.controllerMapper = controllerMapper;
    }

}

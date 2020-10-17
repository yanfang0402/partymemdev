package com.sjtu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
    private String attenUserName;
    private String attenName;
    private Date attenTime;
}

package com.sjtu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private String activityName;
    private int activityLevel;
    private Date activityBeginTime;
    private Date activityEndTime;
    private int activityEnabled;
}

package com.sjtu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Party {
    private String partyName;
    private String partyControllerName;
    private Date partyDate;
}

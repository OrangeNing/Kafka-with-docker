package com.example.kafkatest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlarmIn {
    /**
     * ID
     */
    private Integer id;

    /**
     * 进入告警的人员姓名
     */
    private String personName;

    /**
     * 进入告警的区域名称
     */
    private String areaName;

    /**
     * 告警级别
     */
    private Integer level;

}

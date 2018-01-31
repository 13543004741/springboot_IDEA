package org.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by langye on 2017/12/28.
 * 定时任务类
 */
@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 1000)
    public void add(){
        //System.out.println("我正在执行...."+System.currentTimeMillis());
    }
}

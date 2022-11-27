package com.atguigu.yygh.hosp.repository;

import com.atguigu.yygh.model.hosp.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * <p>
 *
 * </p>
 *
 * @Author chengankang
 * @Date 2022/11/27 17:24
 * @Description
 */
public interface ScheduleRepository extends MongoRepository<Schedule,String> {

    Schedule getScheduleByHoscodeAndHosScheduleId(String hoscode, String hosScheduleId);
}

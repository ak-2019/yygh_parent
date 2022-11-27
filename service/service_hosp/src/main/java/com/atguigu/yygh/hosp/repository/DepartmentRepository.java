package com.atguigu.yygh.hosp.repository;

import com.atguigu.yygh.model.hosp.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * </p>
 *
 * @Author chengankang
 * @Date 2022/11/27 16:08
 * @Description
 */
@Repository
public interface DepartmentRepository extends MongoRepository<Department,String> {

    Department getDepartmentByHoscodeAndDepcode(String hoscode, String depcode);
}

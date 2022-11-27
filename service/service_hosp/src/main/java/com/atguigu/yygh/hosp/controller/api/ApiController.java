package com.atguigu.yygh.hosp.controller.api;

import com.alibaba.excel.util.StringUtils;
import com.atguigu.yygh.common.exception.YyghException;
import com.atguigu.yygh.common.helper.HttpRequestHelper;
import com.atguigu.yygh.common.result.Result;
import com.atguigu.yygh.common.result.ResultCodeEnum;
import com.atguigu.yygh.common.utils.MD5;
import com.atguigu.yygh.hosp.service.DepartmentService;
import com.atguigu.yygh.hosp.service.HospitalService;
import com.atguigu.yygh.hosp.service.HospitalSetService;
import com.atguigu.yygh.hosp.service.ScheduleService;
import com.atguigu.yygh.model.hosp.Department;
import com.atguigu.yygh.model.hosp.Schedule;
import com.atguigu.yygh.vo.hosp.DepartmentQueryVo;
import com.atguigu.yygh.vo.hosp.ScheduleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Author chengankang
 * @Date 2022/11/27 10:51
 * @Description
 */
@Api(tags = "医院管理API接口")
@RestController
@RequestMapping("/api/hosp")
public class ApiController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalSetService hospitalSetService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ScheduleService scheduleService;


    @ApiOperation(value = "删除科室")
    @PostMapping("schedule/remove")
    public Result removeSchedule(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());

        //必填
        String hosScheduleId = (String)paramMap.get("hosScheduleId");
        if(StringUtils.isEmpty(hosScheduleId)) {
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }
        //签名校验
        String hoscode = (String)paramMap.get("hoscode");
        this.checkSign(hoscode,(String) paramMap.get("sign"));
        scheduleService.remove(hoscode, hosScheduleId);
        return Result.ok();
    }

    @ApiOperation(value = "获取排班分页列表")
    @PostMapping("schedule/list")
    public Result schedule(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        //非必填
        String depcode = (String)paramMap.get("depcode");
        int page = StringUtils.isEmpty(paramMap.get("page")) ? 1 : Integer.parseInt((String)paramMap.get("page"));
        int limit = StringUtils.isEmpty(paramMap.get("limit")) ? 10 : Integer.parseInt((String)paramMap.get("limit"));

        //签名校验
        String hoscode = (String)paramMap.get("hoscode");
        this.checkSign(hoscode,(String) paramMap.get("sign"));

        ScheduleQueryVo scheduleQueryVo = new ScheduleQueryVo();
        scheduleQueryVo.setHoscode(hoscode);
        scheduleQueryVo.setDepcode(depcode);
        Page<Schedule> pageModel = scheduleService.selectPage(page , limit, scheduleQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "上传排班")
    @PostMapping("saveSchedule")
    public Result saveSchedule(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        //签名校验
        this.checkSign((String)paramMap.get("hoscode"),(String) paramMap.get("sign"));
        scheduleService.save(paramMap);
        return Result.ok();
    }

    @ApiOperation(value = "删除科室")
    @PostMapping("department/remove")
    public Result removeDepartment(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        String hoscode = (String)paramMap.get("hoscode");
        //签名校验
        this.checkSign(hoscode,(String) paramMap.get("sign"));
        //必填
        String depcode = (String)paramMap.get("depcode");
        if(StringUtils.isEmpty(depcode)) {
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }


        departmentService.remove(hoscode, depcode);
        return Result.ok();
    }

    @ApiOperation(value = "获取分页列表")
    @PostMapping("department/list")
    public Result department(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        String hoscode = (String)paramMap.get("hoscode");
        //签名校验
        this.checkSign(hoscode,(String) paramMap.get("sign"));
        //非必填
        String depcode = (String)paramMap.get("depcode");
        int page = StringUtils.isEmpty(paramMap.get("page")) ? 1 : Integer.parseInt((String)paramMap.get("page"));
        int limit = StringUtils.isEmpty(paramMap.get("limit")) ? 10 : Integer.parseInt((String)paramMap.get("limit"));


        DepartmentQueryVo departmentQueryVo = new DepartmentQueryVo();
        departmentQueryVo.setHoscode(hoscode);
        departmentQueryVo.setDepcode(depcode);
        Page<Department> pageModel =  departmentService.selectPage(page, limit, departmentQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "上传科室")
    @PostMapping("saveDepartment")
    public Result saveDepartment(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        //签名校验
        this.checkSign((String) paramMap.get("hoscode"),(String) paramMap.get("sign"));

        departmentService.save(paramMap);
        return Result.ok();
    }

    @ApiOperation(value = "获取医院信息")
    @PostMapping("hospital/show")
    public Result hospital(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        //签名校验
        String hoscode = (String)paramMap.get("hoscode");
        this.checkSign(hoscode,(String) paramMap.get("sign"));
//        if (!HttpRequestHelper.isSignEquals(paramMap, hospitalSetService.getSignKey(hoscode))) {
//            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
//        }

        return Result.ok(hospitalService.getByHoscode(hoscode));
    }

    //上传医院接口
    @PostMapping("saveHospital")
    public Result saveHosp(HttpServletRequest request) {
        //获取传递过来的医院信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);
        //签名处理
        this.checkSign((String) paramMap.get("hoscode"),(String) paramMap.get("sign"));
        //base64编码 传输过程中“+”转换为了“ ”，因此我们要转换回来
        String logoDataString = (String) paramMap.get("logoData");
        if (!StringUtils.isEmpty(logoDataString)) {
            String logoData = logoDataString.replaceAll(" ", "+");
            paramMap.put("logoData", logoData);
        }
        //调用service的方法
        hospitalService.save(paramMap);
        return Result.ok();
    }

    private void checkSign(String hoscode,String hospSign){
        if (StringUtils.isEmpty(hoscode)) {
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }
        if (!hospSign.equals(MD5.encrypt( hospitalSetService.getSignKey(hoscode)))) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }
    }

}

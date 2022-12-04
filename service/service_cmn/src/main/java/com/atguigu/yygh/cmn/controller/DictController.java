package com.atguigu.yygh.cmn.controller;

import com.atguigu.yygh.cmn.service.DictService;
import com.atguigu.yygh.common.result.Result;
import com.atguigu.yygh.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author 80707
 * @Date 2021/12/16 11:19
 * @Description
 */
@Api("数据字典接口")
@RestController
@RequestMapping("/admin/cmn/dict")
//@CrossOrigin
public class DictController {

    @Autowired
    private DictService dictService;


    @ApiOperation(value = "获取数据字典名称")
    @GetMapping(value = "/getName/{parentDictCode}/{value}")
    public String getName(@ApiParam(name = "parentDictCode", value = "上级编码", required = true) @PathVariable("parentDictCode") String parentDictCode,
                          @ApiParam(name = "value", value = "值") @PathVariable("value") String value) {
        return dictService.getNameByParentDictCodeAndValue(parentDictCode, value);
    }

    @ApiOperation(value = "获取数据字典名称")
    @ApiImplicitParam(name = "value", value = "值", required = true, dataType = "Long", paramType = "path")
    @GetMapping(value = "/getName/{value}")
    public String getName(@ApiParam(name = "value", value = "值", required = true) @PathVariable("value") String value) {
        return dictService.getNameByParentDictCodeAndValue("", value);
    }

    @ApiOperation(value = "导入数据字典接口")
    @PostMapping("importData")
    public Result importData(MultipartFile file) {
        dictService.importDictData(file);
        return Result.ok();
    }

    @ApiOperation(value = "导出数据字典接口")
    @GetMapping("exportData")
    public void exportDict(HttpServletResponse response) {
        dictService.exportDictData(response);
    }

    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("findChildData/{id}")
    public Result findChildData(@PathVariable Long id) {
        List<Dict> list = dictService.findChlidData(id);
        return Result.ok(list);
    }

    @ApiOperation(value = "根据dictCode获取下级节点")
    @GetMapping(value = "/findByDictCode/{dictCode}")
    public Result<List<Dict>> findByDictCode(
            @ApiParam(name = "dictCode", value = "节点编码", required = true)
            @PathVariable String dictCode) {
        List<Dict> list = dictService.findByDictCode(dictCode);
        return Result.ok(list);
    }
}

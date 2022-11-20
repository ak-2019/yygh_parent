package com.atguigu.yygh.cmn.service;

import com.atguigu.yygh.model.cmn.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author 80707
 * @Date 2021/12/16 11:16
 * @Description
 */
public interface DictService extends IService<Dict> {
    //根据数据id查询子数据列表
    List<Dict> findChlidData(Long id);

    //导出数据字典接口
    void exportDictData(HttpServletResponse response);

    //导入数据字典接口
    void importDictData(MultipartFile file);
}

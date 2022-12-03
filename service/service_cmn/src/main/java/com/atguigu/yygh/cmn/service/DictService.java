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

    /**
     * 根据上级编码与值获取数据字典名称
     * @param parentDictCode
     * @param value
     * @return
     */
    String getNameByParentDictCodeAndValue(String parentDictCode, String value);

    /**
     * 查询dictCode查询下级数据字典
     * @param dictCode
     * @return
     */
    List<Dict> findByDictCode(String dictCode);
}

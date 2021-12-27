package com.atguigu.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @Author 80707
 * @Date 2021/12/18 11:10
 * @Description
 */
public class ExcelListener extends AnalysisEventListener<UserData> {

    //从第二行开始逐行读取
    @Override
    public void invoke(UserData userData, AnalysisContext analysisContext) {
        System.out.println(userData);
    }

    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头信息：" + headMap);
    }

    //读取之后开始执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

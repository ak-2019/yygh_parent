package com.atguigu.easyexcel;

import com.alibaba.excel.EasyExcel;

/**
 * @Author 80707
 * @Date 2021/12/18 11:14
 * @Description
 */
public class TestRead {

    public static void main(String[] args) {
        String fileName = "E:\\TestData\\01.xlsx";
        EasyExcel.read(fileName,UserData.class,new ExcelListener()).sheet().doRead();
    }
}

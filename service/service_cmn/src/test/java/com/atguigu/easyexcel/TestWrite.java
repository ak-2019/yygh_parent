package com.atguigu.easyexcel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 80707
 * @Date 2021/12/18 11:00
 * @Description
 */
public class TestWrite {

    public static void main(String[] args) {
        List<UserData> userDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserData userData = new UserData();
            userData.setUid(i);
            userData.setUsername("aa" + i);
            userDataList.add(userData);
        }
        //设置excel文件路径和名称
        String fileName = "E:\\TestData\\01.xlsx";
        EasyExcel.write(fileName,UserData.class).sheet("用户信息").doWrite(userDataList);
    }
}

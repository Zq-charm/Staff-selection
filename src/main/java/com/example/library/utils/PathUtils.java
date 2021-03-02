package com.example.library.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 路径获取工具类

 */
public class PathUtils {

    public static String getRootPath() {
        //获取跟目录
        File file;
        String path = null;
        try {
            file = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!file.exists()) {
                file = new File("");
            }
            path = file.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return path;
    }
    public static String getTempPath() {
        String rootPath = getRootPath();
        //如果上传目录为/static/temp/，则可以如下获取：
        File file = new File("C:/Users/JJJJ/Desktop/expertdownload/temp");//rootPath,"C:/Users/JJJJ/Desktop/expertdownload/temp"
        if(!file.exists()) {
            boolean mkdirs = file.mkdirs();
        }
        return file.getAbsolutePath();
    }
    public static String getModelPath() {
        String rootPath = getRootPath();
        //如果上传目录为/static/model/，则可以如下获取：
        File file = new File("C:\\Users\\JJJJ\\Desktop\\expertdownload\\model");//rootPath,"C:\\Users\\JJJJ\\Desktop\\expertdownload\\model"
        if(!file.exists()) {
            boolean mkdirs = file.mkdirs();
        }
        return file.getAbsolutePath();
    }
    public static String getExportPath() {
        String rootPath = getRootPath();
        //如果上传目录为/static/export/，则可以如下获取：
        File file = new File("C:/Users/JJJJ/Desktop/expertdownload/export");//rootPath,"C:/Users/JJJJ/Desktop/expertdownload/export"
        if(!file.exists()) {
            boolean mkdirs = file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}

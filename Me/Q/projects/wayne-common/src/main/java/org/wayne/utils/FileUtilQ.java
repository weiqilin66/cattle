package org.wayne.utils;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wayne.entity.JsonRoot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description:
 * @author: lwq
 */
public class FileUtilQ {
    public static final Logger log = LoggerFactory.getLogger(FileUtilQ.class);
    /**
     * 方法 1：使用 FileWriter 写文件
     * @param filepath 文件目录
     * @param content  待写入内容
     * @throws IOException
     */
    public static void fileWriterMethod(String filepath, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.append(content);
        }
    }
    public static String read(String filePath){
        StringBuilder res = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String str;
            while ((str = in.readLine()) != null) {
                res.append(str);
            }
        } catch (IOException e) {
            log.error("读取文件出错",e);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        final String json = read("D:/json.txt");
        final String all = json.replaceAll("g_page_config = ","").replaceAll("}};","");
        final String cardInfo = ReUtil.findAll(all, "\"data\":.*?\"bottomsearch\":");
        final String replace = cardInfo.replace("\"data\":", "").replace("},\"bottomsearch\":", "");
        final Gson gson = new Gson();
        final JsonRoot jsonRoot = gson.fromJson(replace, JsonRoot.class);
        System.out.println(all);
    }

}

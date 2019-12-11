package com.zhunongyun.toalibaba.distributed.concurrent.programming;

import java.io.*;

/**
 * markdown字符替换
 */
public class FileHandler {

    private final static String FILE_PATH = "./concurrent_programming/src/main/resources/";

    public void file() throws IOException {

        StringBuffer stringBuffer = new StringBuffer();

        try (FileReader reader = new FileReader(new File(FILE_PATH + "old_file"));
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            boolean no_handler = false;
            while ((line = br.readLine()) != null) {
                // 处理替换字符
                if (!no_handler && line.indexOf("```") > -1) {
                    no_handler = true;
                } else if (no_handler && line.indexOf("```") > -1) {
                    no_handler = false;
                }

                if (!no_handler) {
                    line = line.replaceAll("：", ":")
                            .replaceAll("（", "(")
                            .replaceAll("）", ")")
                            .replaceAll("。", ".")
                            .replaceAll("，", ",")
                            .replaceAll("、", ",");
                    if (line.matches("^#+ {1}[0-9]+\\.{1}.* {1}.*$")) {
                        line = line.substring(0, line.indexOf(" ", line.lastIndexOf(".")) + 1) + line.substring(line.indexOf(" ", line.lastIndexOf(".")) + 1).replaceAll(" ", "");
                    } else if (line.indexOf(" | ") > -1) {
                        String[] temp = line.split("\\|");

                        StringBuffer sb = new StringBuffer("|");
                        for (int i = 1; i < temp.length; i++) {
                            sb.append(" " + temp[i].replaceAll(" | ", "") + " |");
                        }
                        line = sb.toString();
                    } else if (line.matches("^\\*{1} {1}.*$")) {
                        line = line.substring(0, 2) + line.substring(2).replaceAll(" | ", "");
                    } else {
                        line = line.replaceAll(" | ", "");
                    }
                }
                stringBuffer.append(line).append("\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 写文件
        File outFile = new File(FILE_PATH + "new_file");
        outFile.createNewFile();

        try (FileWriter writer = new FileWriter(outFile);
             BufferedWriter out = new BufferedWriter(writer)) {

            out.write(stringBuffer.toString());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.file();
        System.out.println("执行成功");
    }
}
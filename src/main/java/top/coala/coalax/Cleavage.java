package top.coala.coalax;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * author: by@liuchengming
 * date: 2021/08/14/ 15:26
 * info: 切割表格
 */
public class Cleavage {

    public XSSFWorkbook createWorkbook(String fileName) {
        XSSFWorkbook workbook = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return workbook;
    }
}

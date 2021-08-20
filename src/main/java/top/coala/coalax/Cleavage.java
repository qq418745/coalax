package top.coala.coalax;

import org.apache.poi.ss.usermodel.*;
import top.coala.coalax.utils.ExcelOperationUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * author: by@liuchengming
 * date: 2021/08/14/ 15:26
 * info:
 */
public class Cleavage {

    public Cleavage(String fileName) {
        this.workbook = Cleavage.createWorkbook(fileName);
    }

    private final Workbook workbook;

    public Workbook getWorkbook() {
        return workbook;
    }

    public static Workbook createWorkbook(String fileName) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            return WorkbookFactory.create(fileInputStream);
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
        return null;
    }

    public static void w(String templateName, String path, HashMap<String, List<Row>> groupMap) throws IOException {
        for (String s : groupMap.keySet()) {
            Workbook b = Cleavage.createWorkbook(templateName);
            Sheet sheetAt = b.getSheetAt(0);
            List<Row> xssfRows = groupMap.get(s);
            for (int i = 0; i < xssfRows.size(); i++) {
                Row row = sheetAt.createRow(i + 1);
                ExcelOperationUtil.copyRow(xssfRows.get(i), row);
            }
            b.write(new FileOutputStream(path + s + ".xlsx"));

        }
    }

    public HashMap<String, List<Row>> groupBy(int column) {
        HashMap<String, List<Row>> map = new HashMap<>();
        Sheet sheet;
        if (this.workbook != null) {
            //循环excel中所有的 sheet
            for (int i = 0; i < this.workbook.getNumberOfSheets(); i++) {
                sheet = this.workbook.getSheetAt(i);
                //循环每一个sheet中的每一行
                for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
                    Row row = sheet.getRow(j);
                    if (row == null) {
                        System.out.println("当前行为空 行号: " + j);
                        break;
                    }
                    //获取需要分组的列的格子
                    Cell cell = row.getCell(column);
                    System.out.println(j);
                    if (map.containsKey(cell.getStringCellValue())) {
                        map.get(cell.getStringCellValue()).add(row);
                    } else {
                        ArrayList<Row> objects = new ArrayList<>();
                        objects.add(row);
                        map.put(cell.getStringCellValue(), objects);
                    }
                }

            }
        }
        return map;
    }
}

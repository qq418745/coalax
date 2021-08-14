package top.coala.coalax;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import top.coala.coalax.utils.ExcelOperationUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * author: by@liuchengming
 * date: 2021/07/14/ 12:47
 * info:
 */
public class main {

    public static void main(String[] args) throws IOException {

        Cleavage cleavage = new Cleavage();
        XSSFWorkbook workbook = cleavage.createWorkbook("src/test/1.xlsx");

        XSSFSheet sheet;
        // 搞个map
        HashMap<String, List<XSSFRow>> map = new HashMap<>();

        if (workbook != null) {
            //循环excel中所有的 sheet
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                sheet = workbook.getSheetAt(i);
                //循环每一个sheet中的每一行
                for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
                    XSSFRow row = sheet.getRow(j);
                    if(row == null){
                        break;
                    }
                    XSSFCell cell = row.getCell(7);
                    System.out.println(j);



                    if (map.containsKey(cell.getStringCellValue())) {
                        map.get(cell.getStringCellValue()).add(row);
                    }else{
                        ArrayList<XSSFRow> objects = new ArrayList<>();
                        objects.add(row);
                        map.put(cell.getStringCellValue(), objects);
                    }
                }

            }
        }


        for (String s : map.keySet()) {
            //模板
            Workbook b = WorkbookFactory.create(new FileInputStream("src/test/t.xlsx"));
            Sheet sheetAt = b.getSheetAt(0);
            List<XSSFRow> xssfRows = map.get(s);
            for (int i = 0; i < xssfRows.size(); i++) {
                Row row = sheetAt.createRow(i + 1);
                ExcelOperationUtil.copyRow(xssfRows.get(i), row);
            }
            b.write(new FileOutputStream("src/test/out/" + s + ".xlsx"));

        }

    }


}



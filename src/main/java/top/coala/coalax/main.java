package top.coala.coalax;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import top.coala.coalax.model.Order;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: by@liuchengming
 * date: 2021/07/14/ 12:47
 * info:
 */
public class main {
    static final String ADDRESS ="地址",NAME = "姓名", MOBILE = "电话", COUNT = "数量";
    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FunctionList list = new FunctionList();
                list.setVisible(true);
                }

        });


//        List<String> g = new ArrayList<>();
//        File file = new File("src/test/1.txt");
//        BufferedReader reader = null;
//        String temp = null;
//        int line = 1;
//        try {
//            List<String> address = new ArrayList<>();
//            List<String> name = new ArrayList<>();
//            List<String> mobile = new ArrayList<>();
//            List<Integer> count = new ArrayList<>();
//            reader = new BufferedReader(new FileReader(file));
//            while ((temp = reader.readLine()) != null) {
//                if (temp.contains(ADDRESS) || temp.contains(NAME) || temp.contains(MOBILE) || temp.contains(COUNT)) {
//                    System.out.println("内容:" + "line" + line + ":" + temp);
//                    if (temp.contains(ADDRESS)) {
//                        address.add(temp.replaceAll(":", "").replaceAll("：", "").replaceAll(ADDRESS, ""));
//                    }
//                    if (temp.contains(NAME)) {
//                        name.add(temp.replaceAll(":", "").replaceAll("：", "").replaceAll(NAME, ""));
//                    }
//                    if (temp.contains(MOBILE)) {
//                        mobile.add(getNumber(temp));
//                    }
//                    if (temp.contains(COUNT)) {
//                        count.add(Integer.parseInt(getNumber(temp)));
//                    }
//                } else {
//                    g.add("无效行内容:" + "line" + line + ":" + temp);
//                }
//                line++;
//            }
//
//            if (address.size() == name.size() && name.size() == mobile.size() && count.size() == mobile.size()) {
//                ArrayList<Order> orders = new ArrayList<>();
//                for (int i = 0; i < address.size(); i++) {
//                    orders.add(new Order(address.get(i), name.get(i), mobile.get(i), count.get(i)));
//                }
//
//                //读模板
//
//                Workbook b = Cleavage.createWorkbook("src/test/t2.xlsx");
//                Sheet sheetAt = b.getSheetAt(0);
//                for (int i = 0; i < orders.size(); i++) {
//                    Order order = orders.get(i);
//                    Row row = sheetAt.createRow(i + 1);
//                    row.createCell(0).setCellValue(i + 1);
//                    row.createCell(1).setCellValue(order.getName());
//                    row.createCell(2).setCellValue(order.getMobile());
//                    row.createCell(3).setCellValue(order.getAddress());
//                    row.createCell(4).setCellValue(order.getCount());
//                }
//                b.write(new FileOutputStream("src/test/" + "test" + ".xlsx"));
//
//            } else {
//                System.out.println("结果不对等");
//            }
//
//            System.out.println("==============");
//            System.out.println("==============");
//            g.forEach(System.out::println);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }





    }

    public static String getNumber(String mobile) {
        List<String> digitList = new ArrayList<String>();
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(mobile);
        String result = m.replaceAll("");
        for (int i = 0; i < result.length(); i++) {
            digitList.add(result.substring(i, i+1));

        }
        StringBuilder s = new StringBuilder();
        for (String s1 : digitList) {
            s.append(s1);
        }
        return s.toString();
    }
    public static void cleavage()  throws IOException{
        Cleavage cleavage = new Cleavage("src/test/1.xlsx");
        HashMap<String, List<Row>> map = cleavage.groupBy(7);
        Cleavage.w("src/test/t.xlsx", "src/test/out/", map);
    }


}



package top.coala.coalax.view;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import top.coala.coalax.Cleavage;
import top.coala.coalax.FunctionList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * author: by@liuchengming
 * date: 2021/08/19/ 18:02
 * info:
 */
public class ExcelCleavageFrame  extends JFrame {

    CleavagePanel cleavagePanel;
    public ExcelCleavageFrame() {
        setTitle("excel 按列切割");
        setLayout(new BorderLayout());
        pack();
        setSize(800, 560);
        setResizable(false);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        cleavagePanel = new CleavagePanel();
        DeviceSearchResultShowListPanel facePanel = new DeviceSearchResultShowListPanel();
//
        add(cleavagePanel, BorderLayout.NORTH);
        add(facePanel, BorderLayout.CENTER);

        cleavagePanel.addStartBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 100; i++) {
                    table.setValueAt(""  , i, 0);
                }

                try {

                    String columnText = cleavagePanel.columnText.getText().trim();
                    String fileTxt = cleavagePanel.fileText.getText().trim();
                    String outText = cleavagePanel.outText.getText().trim();
                    String tText = cleavagePanel.tText.getText().trim();
                    try {
                        Integer.parseInt(columnText);
                    } catch (NumberFormatException numberFormatException) {
                        table.setValueAt("切割列序号 应该为数字! 处理失败"  , 7, 0);
                        numberFormatException.printStackTrace();
                        return;
                    }
                    int column =  Integer.parseInt(columnText) + 1;

                    table.setValueAt("开始工作: ", 0, 0);
                    table.setValueAt("切割列序号: " + column, 1, 0);
                    table.setValueAt("源表格文件: " + fileTxt , 2, 0);
                    table.setValueAt("模板表格文件: " + tText, 3, 0);
                    table.setValueAt("输出路径" + outText , 4, 0);
                    table.repaint();
                    table.setValueAt("============================" , 5, 0);


                    Cleavage cleavage = new Cleavage(fileTxt);

                    if (cleavage.getWorkbook() == null) {
                        table.setValueAt("读取源表格文件失败 处理失败" , 7, 0);
                        return;
                    }
                    if (Cleavage.createWorkbook(tText) == null) {
                        table.setValueAt("未找到模板表格文件 处理失败"  , 7, 0);
                        return;
                    }

                    String columnValue = cleavage.getWorkbook().getSheetAt(0).getRow(0).getCell(column).getStringCellValue();
                    table.setValueAt("切割列名为: " + columnValue , 7, 0);
                    table.setValueAt("开始分组" + columnValue , 8, 0);
                    HashMap<String, List<Row>> map = cleavage.groupBy(column);
                    table.setValueAt("分组成功" + columnValue , 9, 0);
                    table.setValueAt("============================" , 10, 0);
                    try {

                        table.setValueAt("开始输出结果"  , 11, 0);
                        Cleavage.w(tText, outText, map);
                        table.setValueAt("开始完成!结束工作"  , 12, 0);
                    } catch (IOException ioException) {
                        table.setValueAt("警告!发生错误!失败!"  , 13, 0);
                        ioException.printStackTrace();
                    }
                } catch (NumberFormatException numberFormatException) {
                    table.setValueAt("警告!发生未知错误!失败!"  , 15, 0);
                    numberFormatException.printStackTrace();
                }
            }
        });
//
//        loginPanel.addLogoutBtnActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.setTitle(Res.string().getFaceRecognition());
//                logout();
//            }
//        });
//
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        FunctionList demo = new FunctionList();
                        demo.setVisible(true);
                    }
                });
            }
        });
    }

    public class CleavagePanel extends JPanel {

        public JLabel column;
        public JLabel file;
        public JLabel outLabel;
        public JLabel tLabel;

        public JTextField columnText;
        public JTextField fileText;
        public JTextField outText;
        public JTextField tText;

        public JButton startBtn;


        public CleavagePanel() {


            column = new JLabel("切割列序号");
            columnText = new JTextField("");

            file = new JLabel("源表格文件");
            fileText = new JTextField("D:/coalax/1.xlsx",JLabel.CENTER);

            tLabel =  new JLabel("模板表格文件");
            tText = new JTextField("D:/coalax/t.xlsx",JLabel.CENTER);

            outLabel = new JLabel("输出文件路径");
            outText = new JTextField("D:/coalax/out/",JLabel.CENTER);

            startBtn = new JButton("开始切割");

            add(column);
            add(columnText);
            add(file);
            add(fileText);
            add(tLabel);
            add(tText);
            add(outLabel);
            add(outText);
            add(startBtn);


            fileText.setPreferredSize(new Dimension(90, 20));
            columnText.setPreferredSize(new Dimension(90, 20));
            outText.setPreferredSize(new Dimension(90, 20));
            tText.setPreferredSize(new Dimension(80, 20));
            startBtn.setPreferredSize(new Dimension(80, 20));

        }

        public void addStartBtnActionListener(ActionListener e) {
            startBtn.addActionListener(e);
        }


    }

    private Object[][] data;
    private static DefaultTableModel defaultModel;
    private static JTable table;
    /*
     * 日志
     */
    private class DeviceSearchResultShowListPanel extends JPanel {
        private static final long serialVersionUID = 1L;

        public DeviceSearchResultShowListPanel() {
            setLayout(new BorderLayout());
            data = new Object[10000][1];
            defaultModel = new DefaultTableModel(data, new String[]{"日志"});
            table = new JTable(defaultModel) {   // 列表不可编辑
                private static final long serialVersionUID = 1L;
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // 只能选中一行

            table.getColumnModel().getColumn(0).setPreferredWidth(1000);

            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            add(scrollPane, BorderLayout.CENTER);

        }
    }

    public static class ExcelCleavage {
        public static void main() {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ExcelCleavageFrame demo = new ExcelCleavageFrame();
                    demo.setVisible(true);
                }
            });
        }
    }

}




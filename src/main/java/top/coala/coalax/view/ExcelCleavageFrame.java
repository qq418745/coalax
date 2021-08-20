package top.coala.coalax.view;

import top.coala.coalax.FunctionList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
//        FaceRecognitionEventPanel facePanel = new FaceRecognitionEventPanel();
//
        add(cleavagePanel, BorderLayout.NORTH);
//        add(facePanel, BorderLayout.CENTER);
//
//
//        cleavagePanel.addLoginBtnActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(loginPanel.checkLoginText()) {
//                    if(login()) {
//                        frame = ToolKits.getFrame(e);
//                        frame.setTitle(Res.string().getFaceRecognition() + " : " + Res.string().getOnline());
//                    }
//                }
//
//            }
//        });
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
        public JLabel portLabel;

        public JTextField columnText;
        public JTextField fileText;
        public JTextField outText;

        public JButton startBtn;


        public CleavagePanel() {


            column = new JLabel("需要切割的列");
            columnText = new JTextField("0");
            file = new JLabel("原始文件");
            fileText = new JTextField("D://1.excel");
            portLabel = new JLabel("输出文件路径");
            outText = new JTextField("D://out/");

            startBtn = new JButton("开始切割");

            add(column);
            add(columnText);
            add(file);
            add(fileText);
            add(portLabel);
            add(outText);
            add(startBtn);


            fileText.setPreferredSize(new Dimension(90, 20));
            columnText.setPreferredSize(new Dimension(90, 20));
            outText.setPreferredSize(new Dimension(90, 20));

            startBtn.setPreferredSize(new Dimension(80, 20));

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




package top.coala.coalax;

import top.coala.coalax.view.ExcelCleavageFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * author: by@liuchengming
 * date: 2021/08/19/ 17:52
 * info: 功能列表界面
 */
public class FunctionList extends JFrame {

    public FunctionList() {
        setTitle("功能");
        setLayout(new BorderLayout());
        pack();
        setSize(450, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        add(new FunctionPanel(), BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    /*
     * 功能列表组件
     */
    private JButton faceRecognitionBtn;
    private JButton capturePictureBtn;
    private JButton realPlayBtn;
    private JButton downloadBtn;
    private JButton itsEventBtn;
    private JButton talkBtn;
    private JButton deviceSearchAndInitBtn;
    private JButton ptzBtn;
    private JButton deviceCtlBtn;
    private JButton alarmListenBtn;
    private JButton autoRegisterBtn;
    private JButton attendanceBtn;
    private JButton gateBtn;
    private JButton thermalCameraBtn;
    private JButton matrixScreenBtn;
    private JButton humanNumberStatisticBtn;
    private JButton vtoBtn;

    public class FunctionPanel extends JPanel {
        private static final long serialVersionUID = 1L;

        public FunctionPanel() {
            setLayout(new GridLayout(9, 2));

            setBorder(new EmptyBorder(30, 50, 0, 50));

            faceRecognitionBtn = new JButton("excel按列切割");
//            gateBtn = new JButton("1");
//            capturePictureBtn = new JButton("1");
//            realPlayBtn = new JButton("1");
//            itsEventBtn = new JButton("1");
//            downloadBtn = new JButton("1");
//            talkBtn = new JButton("1");
//            deviceSearchAndInitBtn = new JButton("1");
//            ptzBtn = new JButton("1");
//            deviceCtlBtn = new JButton("1");
//            alarmListenBtn = new JButton("1");
//            autoRegisterBtn = new JButton("1");
//            attendanceBtn = new JButton("1");
//            thermalCameraBtn = new JButton("1");
//            matrixScreenBtn = new JButton("1");
//            humanNumberStatisticBtn = new JButton("1");
            vtoBtn = new JButton("1");
            add(faceRecognitionBtn);
//            add(gateBtn);
//            add(deviceSearchAndInitBtn);
//            add(ptzBtn);
//            add(realPlayBtn);
//            add(capturePictureBtn);
//            add(talkBtn);
//            add(itsEventBtn);
//            add(downloadBtn);
//            add(deviceCtlBtn);
//            add(alarmListenBtn);
//            add(autoRegisterBtn);
//            add(attendanceBtn);
//            add(thermalCameraBtn);
//            add(matrixScreenBtn);
//            add(humanNumberStatisticBtn);
//            add(vtoBtn);
//            gateBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            Gate.main(null);
//                        }
//                    });
//                }
//            });

            faceRecognitionBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            dispose();
                            ExcelCleavageFrame.ExcelCleavage.main();
                        }
                    });
                }
            });
//
//
//            capturePictureBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            CapturePicture.main(null);
//                        }
//                    });
//                }
//            });
//
//            realPlayBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            RealPlay.main(null);
//                        }
//                    });
//                }
//            });
//
//            downloadBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            DownLoadRecord.main(null);
//                        }
//                    });
//                }
//            });
//
//            talkBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            Talk.main(null);
//                        }
//                    });
//                }
//            });
//
//            itsEventBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            TrafficEvent.main(null);
//                        }
//                    });
//                }
//            });
//
//            deviceSearchAndInitBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            DeviceSearchAndInit.main(null);
//                        }
//                    });
//                }
//            });
//
//            ptzBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            PTZControl.main(null);
//                        }
//                    });
//                }
//            });
//
//            deviceCtlBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            DeviceControl.main(null);
//                        }
//                    });
//                }
//            });
//
//            alarmListenBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            AlarmListen.main(null);
//                        }
//                    });
//                }
//            });
//
//            autoRegisterBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            AutoRegister.main(null);
//                        }
//                    });
//                }
//            });
//
//            attendanceBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            Attendance.main(null);
//                        }
//                    });
//                }
//            });
//
//            thermalCameraBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
//                            dispose();
//                            ThermalCamera.main(null);
//                        }
//                    });
//                }
//            });
//
//
//            matrixScreenBtn.addActionListener(new ActionListener() {
//                @Override public void actionPerformed(ActionEvent e) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run()
//                        {
//                            dispose();
//                            LatticeScreen.main(null);
//                        }
//                    });
//                }
//            });
//
//
//            humanNumberStatisticBtn.addActionListener(new ActionListener() {
//
//                @Override public void actionPerformed(ActionEvent e) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run()
//                        {
//                            dispose();
//                            HumanNumberStatistic.main(null);
//                        }
//                    });
//                }
//            });
//            vtoBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            dispose();
//                            VTODemo.main(null);
//                        }
//                    });
//                }
//            });


        }


    }
}

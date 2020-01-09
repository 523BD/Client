package cn.zzh;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientUI extends JFrame {

    public static void main(String[] args) {
        new ClientUI();
    }

    public     JButton btStart;
    public     JButton btSend;
    public     JButton btFile;
    public     JTextField tfSend; //装在输入文字
    public     JTextPane  nameText; //输入名字
    public     JTextPane  ipTex; //输入名字
    public     JTextPane  portText; //输入名字
    public     JTextField tfName; //服务器ip
    public     JTextField tfIP; //服务器ip
    public     JTextField tfPort; //服务器端口
    public     JTextArea taShow;
    public     Client server;

    public ClientUI() {
        super("客户端");
        btStart = new JButton();
        // 去掉背景点击效果
        btStart.setContentAreaFilled(false);  
        //去掉聚焦线
        btStart.setFocusPainted(false);
        // 去掉边框
        btStart.setBorder(null);
        btSend = new JButton("发送信息");
        btFile = new JButton("传送文件");
        tfSend = new JTextField(20);
        tfIP = new JTextField(8);
        tfPort = new JTextField(3);
        tfName = new JTextField(6);
        nameText = new JTextPane();nameText.setText("登录名");nameText.setEditable(false);
        ipTex = new JTextPane();ipTex.setText("服务地址");ipTex.setEditable(false);
        portText = new JTextPane();portText.setText("服务端口");portText.setEditable(false);
        taShow = new JTextArea();
        //启动链接按钮事件
        ImageIcon login_0 = new ImageIcon("Client/image/connect.png");
        btStart.setSize(100,100);
        btStart.setIcon(login_0);
        btStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                server = new Client(ClientUI.this);
            }
        });
        //发送按钮事件
        btSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                if (name == null || "".equals(name)) {
                    name = "匿名者";
                }
                server.sendMsg(name + "：" + tfSend.getText());
                tfSend.setText("");
            }
        });
        btFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }

        });
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "确定关闭吗？", "温馨提示",
                        JOptionPane.YES_NO_OPTION);
                if (a == 1) {
                    System.exit(0); // 关闭
                }
            }
        });
        //底部的发送信息框与链接按钮
        JPanel top = new JPanel(new FlowLayout());
        top.add(tfSend); //发送文本
        top.add(btSend); //发送按钮
        top.add(btFile);//发送文件
        this.add(top, BorderLayout.SOUTH); //加载到底部

        //头部放连接服务的
        JPanel northJpannel = new JPanel(new FlowLayout());
        northJpannel.add(nameText);
        northJpannel.add(tfName);
        northJpannel.add(ipTex);
        northJpannel.add(tfIP);
        northJpannel.add(portText);
        northJpannel.add(tfPort);
        northJpannel.add(btStart);
        this.add(northJpannel,BorderLayout.NORTH);  //加载到头部

        final JScrollPane sp = new JScrollPane();
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setViewportView(this.taShow);
        this.taShow.setEditable(false);
        this.add(sp, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Image icon = toolkit.getImage("src/image/koisakura.jpg");
        this.setIconImage(icon);
        this.setSize(500, 400);
        this.setLocation(600, 200);
        this.setVisible(true);
    }



}
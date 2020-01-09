package cn.zzh;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
 
public class Verify extends JFrame {
	private JButton b1;
	private JTextField VC; 
	private JLabel j1; 
	private JLabel j2; 
	public String a;
	public Verify(String v,String p) throws IOException {
		 a = p;
		 //设置登录窗口标题
		 this.setTitle("验证码");
		 //采用指定的窗口装饰风格 
		 this.getRootPane().setWindowDecorationStyle(JRootPane.NONE); 
		 //窗体组件初始化 
		 init(v); 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 //设置布局为绝对定位 
		 this.setLayout(null); 
		 this.setBounds(0, 0, 355, 265); 
		 //设置窗体的图标 
		 Toolkit toolkit=Toolkit.getDefaultToolkit();
		  Image icon = toolkit.getImage("src/image/koisakura.jpg");
		  this.setIconImage(icon);
		 //窗体大小不能改变 
		 this.setResizable(false); 
		 //居中显示 
		 this.setLocationRelativeTo(null); 
		 //窗体显示 
		 this.setVisible(true); 
		 //清除背景
//		 this.setBackground(new Color(0,0,0,0));
	}
	public void paint(Graphics g) {	//绘制验证码
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		ImageIcon ii1 = new ImageIcon(a);
		g2.drawImage(ii1.getImage(),70, 60, 200, 80, null);
	}
	private void init(String v) {
		// TODO Auto-generated method stub
		//创键并设置窗体
		Container container = this.getContentPane(); 
		  j1 = new JLabel(); 
		  //设置背景色 
		  Image img1 = new ImageIcon("Client/image/"+v+".jpg").getImage(); 
		  j1.setIcon(new ImageIcon(img1)); 
		  j1.setBounds(0, 0, 355, 265); 
		b1=new JButton("确认");
		VC = new JTextField(); 
		VC.setBounds(120, 130, 150, 20); 
		b1.setFont(new Font("宋体", Font.PLAIN, 12)); 
		b1.setBounds(50, 130, 60, 30); 
		b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String vc = VC.getText();
				if(vc.equals(v)) {
					setVisible(true);

		    	 JOptionPane.showMessageDialog(null, "验证码正确");
		    	 dispose();
				ReadCmdLine.read();
				}else {
					JOptionPane.showMessageDialog(null, "验证码错误！！！");
					dispose();
					new Login();
				}
			}
			
		});

		j1.add(b1);
		container.add(j1); 
		container.add(VC);
		
		//窗体关闭时退出程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Verify.this.dispose();
	}

	public static void main(String[] args) {
		//new ClientUI();
	}
};




	//创键一个窗体，并显示


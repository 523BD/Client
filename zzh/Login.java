package cn.zzh;
import java.awt.Color; 
import java.awt.Container; 
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import javax.swing.JCheckBox; 
import javax.swing.JComboBox; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField; 
import javax.swing.JRootPane; 
import javax.swing.JTextField; 
  
public class Login extends JFrame{ 
	public static final String VERIFY_PICTURE = "F:\\VC\\image\\";
    private static void useAWTDesktop(String v) throws IOException {
        Desktop.getDesktop().open(new File(v));
    }

 private static final long serialVersionUID = -6788045638380819221L; 
 //用户名 
 private JTextField ulName; 
 //密码 
 private JPasswordField ulPasswd; 
 //小容器 
 private JLabel j1; 
 private JLabel j2; 
 private JLabel j3; 
 private JLabel j4; 
 //小按钮 
 private JButton b0;
 private JButton b1; 
 private JButton b2; 
 private JButton b3; 
 //复选框 
 private JCheckBox c1; 
 private JCheckBox c2; 
 //列表框 
 private JComboBox<String> cb1; 
 /** 
  * 初始化登录页面 
  * */
 public Login(){ 
  //设置登录窗口标题 
  this.setTitle("Πολική "
  		+ "αρκούδα"); 
  //去掉窗口的装饰(边框) 
  this.setUndecorated(true);  
  //窗体组件初始化 
  init(); 
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  //设置布局为绝对定位 
  this.setLayout(null); 
  //设置窗体的图标 
  Toolkit toolkit=Toolkit.getDefaultToolkit();
  Image icon = toolkit.getImage("Client/image/koisakura.jpg");
  this.setIconImage(icon);
  //窗体大小
  this.setSize(1080, 720); 
  //窗体大小不能改变 
  this.setResizable(false); 
  //居中显示 
  this.setLocationRelativeTo(null); 
  //窗体显示 
  this.setVisible(true); 
  //清楚背景
  this.setBackground(new Color(0, 0, 0, 0));
 } 
 /** 
  * 窗体组件初始化 
  * */
 public void init(){ 
  //创建一个容器,其中的图片大小和setBounds第三、四个参数要基本一致(需要自己计算裁剪) 
  Container container = this.getContentPane(); 
  
  j1 = new JLabel(); 
  //设置背景色 
  Image img1 = new ImageIcon("Client/image/1.jpg").getImage(); 
  j1.setIcon(new ImageIcon(img1)); 
  j1.setBounds(0, 0, 1080, 720); 
  //头像设定 
  j2 = new JLabel(); 
  Image img2 = new ImageIcon("Client/image/1.png").getImage(); 
  j2.setIcon(new ImageIcon(img2)); 
  j2.setBounds(400, 255, 50, 53); 
  //用户名输入框 
  ulName = new JTextField(); 
  ulName.setBounds(465, 260, 155, 20); 
  
  //注册账号 
  j3 = new JLabel("账号"); 
  j3.setBounds(625, 260, 70, 20); 
  //密码输入框 
  ulPasswd = new JPasswordField(); 
  ulPasswd.setBounds(465, 290, 155, 20); 
  //找回密码 
  j4= new JLabel("密码");
  j4.setBounds(625, 290, 70, 20); 
  //记住密码 
  c1 = new JCheckBox("记住密码");
  c1.setBounds(465, 315, 80, 15); 
  //自动登陆 
  c2 = new JCheckBox("自动登陆"); 
  c2.setBounds(545, 315, 80, 15); 
  //用户登陆状态选择 
  cb1 = new JComboBox<String>(); 
  cb1.addItem("在线"); 
  cb1.addItem("隐身"); 
  cb1.addItem("离开"); 
  cb1.setBounds(400, 310, 55, 20); 
  //退出按钮
  b0 = new JButton();
  //设置按钮大小位置
  b0.setBounds(950, 100, 30, 30);
  ImageIcon exit_0 = new ImageIcon("Client/image/exit_0.png");
  ImageIcon exit_1 = new ImageIcon("Client/image/exit_1.png");
  b0.setIcon(exit_0);
  b0.setPressedIcon(exit_1);
  //设定透明效果
  b0.setOpaque(false);  
  // 去掉背景点击效果
  b0.setContentAreaFilled(false);  
  // 去掉聚焦线
  b0.setFocusPainted(false);
  // 去掉边框
  b0.setBorder(null);
  b0.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		  System.exit(0);
		  }
	  });
  //登陆按钮 
  b1 = new JButton("登录"); 
  //设置字体和颜色和手形指针 
  b1.setFont(new Font("宋体", Font.PLAIN, 12)); 
  b1.setForeground(Color.BLUE); 
  b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
  b1.setBounds(700, 240, 100, 100); 
  ImageIcon login_0 = new ImageIcon("Client/image/login_0.png");
  b1.setIcon(login_0);
  //设定透明效果
  b1.setOpaque(false);  
  // 去掉背景点击效果
  b1.setContentAreaFilled(false);  
  //去掉聚焦线
  b1.setFocusPainted(false);
  // 去掉边框
  b1.setBorder(null);
  //给按钮添加 
  b1.addActionListener(new ActionListener() { 
   @Override
   public void actionPerformed(ActionEvent e) {
	  Boolean flag=false;
    String cmd = e.getActionCommand(); 
    if("登录".equals(cmd)){ 
     String username = ulName.getText(); 
     String userpassword = ulPasswd.getText(); 
     String euserpassword = Kaisapwd.Encrypt(userpassword);
     String eusername = Kaisapwd.Encrypt(userpassword);
     List<String[]> list=Tool.search();
     for(String[] array:list) {
    	 if(eusername.equals(array[0])) {
    		 if(euserpassword.equals(array[1])) {
    			 flag = true;
    			 Login.this.dispose();
                 try {
                     new VerifyCodeUtils();
                 } catch (IOException ex) {
                     ex.printStackTrace();
                 }
                 break;
    		 }else {
    			 //JOptionPane.showConfirmDialog(null, "请输入正确的密码");
                 if(array[1]==null){
                     try {
                         new VerifyCodeUtils();
                     } catch (IOException e1) {
                         // TODO Auto-generated catch block
                         e1.printStackTrace();
                     }
                     break;
                 }
    		 }
    	 }else {
             if(array[0]==null){
    		 try {
					new VerifyCodeUtils();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		 break;
    	  }
         }
     }
     if(flag.equals(false)) {
//     JOptionPane.showConfirmDialog(null, "请输入正确的用户名或密码"); 
     }
     
    }
    //Login.this.dispose();
   } 
   
  }); 
  //多账号 
  b2 = new JButton("多账号"); 
  b2.setBounds(465, 360, 70, 20);
  b2.addActionListener(new ActionListener() { 
	   @Override
	   public void actionPerformed(ActionEvent e) { 
		   new Login();
	   }
	   });
  //设置 
  b3 = new JButton("注册"); 
  b3.setBounds(550, 360, 70, 20); 
  b3.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 String username = ulName.getText(); 
	     String userpassword = ulPasswd.getText();
	     String euserpassword = Kaisapwd.Encrypt(userpassword);
	     String eusername = Kaisapwd.Encrypt(userpassword);
		Tool.insert(eusername, euserpassword);
		 JOptionPane.showConfirmDialog(null, "注册成功"); 
	}
	  
  });
  //所有组件用容器装载 
  j1.add(j2); 
  j1.add(j3); 
  j1.add(j4); 
  j1.add(c1); 
  j1.add(c2); 
  j1.add(cb1); 
  j1.add(b0);
  j1.add(b1); 
  j1.add(b2); 
  j1.add(b3); 
  container.add(j1); 
  container.add(ulName); 
  container.add(ulPasswd); 
 } 
public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g; // 强转成2D
		ImageIcon ii1 = new ImageIcon("Client/image/bg.png");
		g2.drawImage(ii1.getImage(), 0, 0, 1080, 720, null);
		ImageIcon login_0 = new ImageIcon("Client/image/login_0.png");
		g2.drawImage(login_0.getImage(), 700, 240, 100, 100, null);
	}
 public static void main(String[] args) throws IOException { 
  new Login(); 
 } 
} 
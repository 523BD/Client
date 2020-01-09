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
		 //���õ�¼���ڱ���
		 this.setTitle("��֤��");
		 //����ָ���Ĵ���װ�η�� 
		 this.getRootPane().setWindowDecorationStyle(JRootPane.NONE); 
		 //���������ʼ�� 
		 init(v); 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 //���ò���Ϊ���Զ�λ 
		 this.setLayout(null); 
		 this.setBounds(0, 0, 355, 265); 
		 //���ô����ͼ�� 
		 Toolkit toolkit=Toolkit.getDefaultToolkit();
		  Image icon = toolkit.getImage("src/image/koisakura.jpg");
		  this.setIconImage(icon);
		 //�����С���ܸı� 
		 this.setResizable(false); 
		 //������ʾ 
		 this.setLocationRelativeTo(null); 
		 //������ʾ 
		 this.setVisible(true); 
		 //�������
//		 this.setBackground(new Color(0,0,0,0));
	}
	public void paint(Graphics g) {	//������֤��
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		ImageIcon ii1 = new ImageIcon(a);
		g2.drawImage(ii1.getImage(),70, 60, 200, 80, null);
	}
	private void init(String v) {
		// TODO Auto-generated method stub
		//���������ô���
		Container container = this.getContentPane(); 
		  j1 = new JLabel(); 
		  //���ñ���ɫ 
		  Image img1 = new ImageIcon("Client/image/"+v+".jpg").getImage(); 
		  j1.setIcon(new ImageIcon(img1)); 
		  j1.setBounds(0, 0, 355, 265); 
		b1=new JButton("ȷ��");
		VC = new JTextField(); 
		VC.setBounds(120, 130, 150, 20); 
		b1.setFont(new Font("����", Font.PLAIN, 12)); 
		b1.setBounds(50, 130, 60, 30); 
		b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String vc = VC.getText();
				if(vc.equals(v)) {
					setVisible(true);

		    	 JOptionPane.showMessageDialog(null, "��֤����ȷ");
		    	 dispose();
				ReadCmdLine.read();
				}else {
					JOptionPane.showMessageDialog(null, "��֤����󣡣���");
					dispose();
					new Login();
				}
			}
			
		});

		j1.add(b1);
		container.add(j1); 
		container.add(VC);
		
		//����ر�ʱ�˳�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Verify.this.dispose();
	}

	public static void main(String[] args) {
		//new ClientUI();
	}
};




	//����һ�����壬����ʾ


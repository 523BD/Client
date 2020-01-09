package cn.zzh;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
 
/**
 * @author ���
 * 
 */
public class Client extends Thread {
 
    ClientUI ui;
    Socket client;
    BufferedReader reader;
    PrintWriter writer;
 
    public Client(ClientUI ui) {
        this.ui = ui;
        try {
            String ip = ui.tfIP.getText(); //�õ������ip��ַ
            int port = Integer.parseInt(ui.tfPort.getText()); //�õ�����Ķ˿�
            client = new Socket(ip, port);//�����������ӷ������˵�IP�Ķ˿�
            println("���ӷ������ɹ����������˿ڵ�ַ��" + port);
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer = new PrintWriter(client.getOutputStream(), true);
            String name = ui.tfName.getText();
            if (name == null || "".equals(name)) {
                name = "������";
            }
            sendMsg(name+"����������........................");
            // ���Ϊ true���� println��printf �� format ������ˢ�����������
        } catch (NumberFormatException nu) {
            println("�˿���������ȷ.......");
            nu.printStackTrace();
        } catch (IOException e) {
            println("���ӷ�����ʧ�ܣ���������ȷ��IP��ַ��˿�");
            println(e.toString());
            e.printStackTrace();
        }
        this.start();
    }
 
    public void run() {
        String msg = "";
        while (true) {
            try {
                msg = reader.readLine();
            } catch (IOException e) {
                println("�������Ͽ�����");
 
                break;
            }
            if (msg != null && msg.trim() != "") {
                println(msg);
            }
        }
    }
 
    public void sendMsg(String msg) {
        try {
            writer.println(msg);
        } catch (Exception e) {
            println(e.toString());
        }
    }
 
    public void println(String s) {
        if (s != null) {
            this.ui.taShow.setText(this.ui.taShow.getText() + s + "\n");
            System.out.println(s + "\n");
        }
    }
 
}
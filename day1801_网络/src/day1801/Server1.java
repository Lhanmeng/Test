package day1801;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws Exception {
		//�ڱ�����8000�˿�����������
		ServerSocket ss = 
			new ServerSocket(8000);
		
		//��ͣ���ȴ��ͻ�������
		Socket s = ss.accept();
		//��Socket����ͨ����ȡ�������������
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		
		//���տͻ��˵�����
		int b;
		while((b = in.read()) != -1) {
			System.out.print((char)b);
		}
		
		ss.close();//ֹͣ����
	}
}





package day1801;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args) throws Exception {
		//��������������ӣ���������ͨ��
		Socket s = new Socket("127.0.0.1", 8000);
		//ȡ����
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		//���������������
		out.write(
		 "hello server, i'm client.".getBytes());
		
		//�Ͽ�����
		s.close();
		
	}
}






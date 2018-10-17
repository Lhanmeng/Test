package day1801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	/**
	 * �����������ķ�����
	 * ���������������߳�
	 */
	public void start() {
		new Thread() {
			@Override
			public void run() {
				try {
					//��������
					ServerSocket ss = new ServerSocket(8000);
					System.out.println("�����Ѿ�����");
					
					while(true) {
						//ѭ���ȴ��ͻ�������
						Socket s = ss.accept();
						//����ͨ���̣߳�����ͨ�������߳�ȥִ��ͨ��    
						TongXinThread t = new TongXinThread(s);
						t.start();
					}
				} catch (Exception e) {
					System.out.println("�����޷����������ѹر�");
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	
	//ͨ���߳���
	class TongXinThread extends Thread {
		Socket s;
		BufferedReader in;
		PrintWriter out;
		public TongXinThread(Socket s) {
			super();
			this.s = s;
		}
		@Override
		public void run() {
			try {
				//������--ISR--BR
				//������--OSW--PW
				in=new BufferedReader(// readLine()
				   new InputStreamReader(//����ת��
				   s.getInputStream(), "GBK"));
				out=new PrintWriter(// println()
				    new OutputStreamWriter(//����ת��
				    s.getOutputStream(), "GBK"));
				
				String line;
				while((line = in.readLine()) != null) {
					out.println(line);
					out.flush();//ˢ����������
					System.out.println(line);
				}				
			} catch (Exception e) {
			}			
			System.out.println("�����ѶϿ�");			
		}
	}	
	
	public static void main(String[] args) {
		EchoServer server = new EchoServer();
		server.start();
	}
	
	
}









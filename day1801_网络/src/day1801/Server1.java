package day1801;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws Exception {
		//在本机的8000端口上启动服务
		ServerSocket ss = 
			new ServerSocket(8000);
		
		//暂停，等待客户端连接
		Socket s = ss.accept();
		//从Socket连接通道，取出两个方向的流
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		
		//接收客户端的数据
		int b;
		while((b = in.read()) != -1) {
			System.out.print((char)b);
		}
		
		ss.close();//停止服务
	}
}





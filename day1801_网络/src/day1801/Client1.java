package day1801;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args) throws Exception {
		//向服务器发起连接，建立连接通道
		Socket s = new Socket("127.0.0.1", 8000);
		//取出流
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		//向服务器发送数据
		out.write(
		 "hello server, i'm client.".getBytes());
		
		//断开连接
		s.close();
		
	}
}






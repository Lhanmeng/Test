package day1801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	/**
	 * 启动服务器的方法，
	 * 创建并启动服务线程
	 */
	public void start() {
		new Thread() {
			@Override
			public void run() {
				try {
					//启动服务
					ServerSocket ss = new ServerSocket(8000);
					System.out.println("服务已经启动");
					
					while(true) {
						//循环等待客户端连接
						Socket s = ss.accept();
						//创建通信线程，连接通道交给线程去执行通信    
						TongXinThread t = new TongXinThread(s);
						t.start();
					}
				} catch (Exception e) {
					System.out.println("服务无法启动，或已关闭");
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	
	//通信线程类
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
				//网络流--ISR--BR
				//网络流--OSW--PW
				in=new BufferedReader(// readLine()
				   new InputStreamReader(//编码转换
				   s.getInputStream(), "GBK"));
				out=new PrintWriter(// println()
				    new OutputStreamWriter(//编码转换
				    s.getOutputStream(), "GBK"));
				
				String line;
				while((line = in.readLine()) != null) {
					out.println(line);
					out.flush();//刷出缓存数据
					System.out.println(line);
				}				
			} catch (Exception e) {
			}			
			System.out.println("连接已断开");			
		}
	}	
	
	public static void main(String[] args) {
		EchoServer server = new EchoServer();
		server.start();
	}
	
	
}









package socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务端-主程序
 * 
 * @author mengzhang6
 *
 */
public class Main extends Thread {

	public static void main(String[] args) throws IOException {

		// 绑定服务端在9999端口
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("服务端启动成功···");
		Socket socket = null;

		while (true) {
			// 监听客户端程序
			socket = serverSocket.accept();
			// 一个客户端连接后启动一个线程进行处理
			Main mainthread = new Main(socket);
			mainthread.start();
		}
	}

	Socket socket = null;

	public Main(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			// 启动一个线程来接收客户端信息
			ThreadServer thread = new ThreadServer(socket);
			thread.start();
			System.out.println("服务端启动一个线程处理客户端请求");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

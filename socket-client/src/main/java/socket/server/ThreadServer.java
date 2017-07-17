package socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadServer extends Thread {
	Socket socket = null;

	public ThreadServer(Socket server) {
		socket = server;
	}

	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			// 循环接受客户端信息
			while (true) {
				String read = br.readLine();
				if (read == null) {
					break;
				}
				System.out.println("服务端接收到的信息是：" + read);
			}

			br.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("服务端处理请求完毕");
		System.out.println("--------------------");
	}

}

package socket.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

/**
 * socket客户端
 * 
 * @author mengzhang6
 *
 */
public class SocketClient {
	public static void main(String[] args) {
		Socket socket = null;
		DataOutputStream outputStream = null;
		String serverIP = "127.0.0.1";// 服务端ip
		int serverPort = 9999;// 服务端 端口号
		try {
			String data = UUID.randomUUID().toString();
			System.out.println("客户端发起请求,数据为:" + data);
			socket = new Socket(serverIP, serverPort);
			outputStream = new DataOutputStream(socket.getOutputStream());
			String str = "Hello World\n你好\t世界\n";
			outputStream.write(str.getBytes());
			outputStream.write(data.getBytes());
			outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("关闭socket异常");
			}
		}
	}

}

package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @Author: Fourteen-Y
 * @Description:
 * @Date: 2022/8/5 11:42
 */
public class UdpEchoClient {
    private DatagramSocket socket = null;

    public UdpEchoClient() throws SocketException {
        socket = new DatagramSocket();
    }
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 让客户端从控制台读取一个请求数据
            System.out.println("> ");
            String request = scanner.next();
            // 2. 把这个字符串请求发送给服务器。构造 DatagramPacket
            // 构造的 Packet 既要包含要传输的数据，又要包含把数据发到哪里
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName("127.0.0.1"),8000);
            // 3. 把数据报发给服务器。
            socket.send(requestPacket);
            // 4. 从服务器读取响应数据
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            // 5. 把响应数据获取出来，转换成字符串。
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());

            System.out.printf("req: %s; resp :%s\n",request,response);
        }
    }
    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient();
        client.start();
    }
}

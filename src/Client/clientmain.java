package Client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class clientmain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DatagramSocket socket = new DatagramSocket();
		byte buffer[] = new byte[256];
		DatagramPacket pk = null;

		InetAddress ip = InetAddress.getByName("10.0.0.35");

		String msg = "오늘의 점심은?";
		buffer = msg.getBytes();
		System.out.println(buffer.length);
		pk = new DatagramPacket(buffer, buffer.length, ip, 9999);

		socket.send(pk);//포트가 열려있는 상태

		//서버로부터 응답처리
		buffer = new byte[256];
		pk = new DatagramPacket(buffer, buffer.length);
		socket.receive(pk);// 보낸다
		
		byte[] cMsg = pk.getData();
		String cMsgs = new String(cMsg);// 문자로 볼 수 있게 스트링으로 변환

		System.out.println("클라이언트 정보-------");
		System.out.println(" ip    : " + pk.getAddress());
		System.out.println("port   : " + pk.getPort());
		System.out.println("message: " + cMsgs);

	}

}

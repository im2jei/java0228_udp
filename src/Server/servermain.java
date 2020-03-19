package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class servermain {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(9999);
		byte buffer[] = new byte[256];
		DatagramPacket pk = null;
		while (true) {
			pk = new DatagramPacket(buffer, buffer.length);//데이터를 담아서
			System.out.println("서버 시작");
			socket.receive(pk);//보낸다

			byte[] cMsg=pk.getData();
			String cMsgs= new String(cMsg);//문자로 볼 수 있게 스트링으로 변환

			System.out.println("클라이언트 정보-------");
			System.out.println(" ip    : "+pk.getAddress());
			System.out.println("port   : "+pk.getPort());
			System.out.println("message: "+cMsgs);
			
			
			//응답
			InetAddress ip= InetAddress.getByName("10.0.0.35");
			
			Woonse w= new Woonse();
			String msg= w.selWoonse();
			
			
		//	String msg="welcome";
			buffer=msg.getBytes();
			pk= new DatagramPacket(buffer,buffer.length,pk.getAddress(),pk.getPort());
			
			socket.send(pk);
			
		}

	}

}

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
			pk = new DatagramPacket(buffer, buffer.length);//�����͸� ��Ƽ�
			System.out.println("���� ����");
			socket.receive(pk);//������

			byte[] cMsg=pk.getData();
			String cMsgs= new String(cMsg);//���ڷ� �� �� �ְ� ��Ʈ������ ��ȯ

			System.out.println("Ŭ���̾�Ʈ ����-------");
			System.out.println(" ip    : "+pk.getAddress());
			System.out.println("port   : "+pk.getPort());
			System.out.println("message: "+cMsgs);
			
			
			//����
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

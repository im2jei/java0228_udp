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

		String msg = "������ ������?";
		buffer = msg.getBytes();
		System.out.println(buffer.length);
		pk = new DatagramPacket(buffer, buffer.length, ip, 9999);

		socket.send(pk);//��Ʈ�� �����ִ� ����

		//�����κ��� ����ó��
		buffer = new byte[256];
		pk = new DatagramPacket(buffer, buffer.length);
		socket.receive(pk);// ������
		
		byte[] cMsg = pk.getData();
		String cMsgs = new String(cMsg);// ���ڷ� �� �� �ְ� ��Ʈ������ ��ȯ

		System.out.println("Ŭ���̾�Ʈ ����-------");
		System.out.println(" ip    : " + pk.getAddress());
		System.out.println("port   : " + pk.getPort());
		System.out.println("message: " + cMsgs);

	}

}

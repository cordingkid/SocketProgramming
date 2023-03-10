package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 이 쓰레드 클래스는 소켓을 통해서 메시지를 받아서 화면에 출력하는 역할을 담당한다.
 * 
 * @author PC-09
 *
 */
public class Receiver extends Thread {
	private Socket socket;
	private DataInputStream din;

	public Receiver(Socket socket) {
		this.socket = socket;

		// 수신용 스트림 객체 생성
		try {
			din = new DataInputStream(this.socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(din != null) {
			try {
				// 메시지를 받아서 화면에 출력하기
				System.out.println(din.readUTF());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

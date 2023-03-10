package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {
	// 연습용이라 오류 처리는 하지 않음
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7777);
		
		System.out.println("서버가 준비중입니다...");
		
		Socket socket = server.accept(); // 클라이언트의 접속 요청 기다리기...
		
		/*
		 *  클라이언트가 접속하면 접속한 Socket객체를 
		 *  메시지를 보내는 쓰레드와 메시지를 받는 쓰레드에 주입하여
		 *  각각의 쓰레드 객체를 생성하여 실행
		 */
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		sender.start();
		receiver.start();
	}
}

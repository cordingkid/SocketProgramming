package kr.or.ddit.basic.tcp;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
/*
 *  서버입장 에서
 *  파일을 출력할위치를 저장해놓고
 *  
 *  그걸 소켓 으로 클라이언트로 바이트를 받아서 
 *  내 파일에다가 아웃으로 출력해서 이미지를 저장한다.
 */
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(7777);
		System.out.println("서버 준비중...");
		
		Socket socket = serverSocket.accept();
		
		
		File file = new File("D:\\D_Other\\연습용/복사본_펭귄.jpg");
		
		InputStream inputStream = socket.getInputStream();
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		
		DataInputStream din = new DataInputStream(inputStream);
		
		System.out.println("클라이언트한테서 온 메세지 : " + din.readUTF());
		
		int c;
		while((c=inputStream.read())!=-1){
			fileOutputStream.write(c);
		}
		fileOutputStream.close();
		socket.close();
	}
}

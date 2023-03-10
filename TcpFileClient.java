package kr.or.ddit.basic.tcp;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpFileClient {
/*
 *  서버한테 이미지를 보내야 하기 때문에 일단
 *  
 *  파일을 바이트로 읽어서
 *  소켓을 가지고 서버한테 바이트를 전송한다.
 */
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.146.76", 7777);
			System.out.println("접속완료");
			
			File file = new File("D:\\D_Other/chopa.jpg");
			FileInputStream fin = new FileInputStream(file);
			
			OutputStream out = socket.getOutputStream();
			
			
			DataOutputStream dot = new DataOutputStream(out);
			
			System.out.println("서버한테 전송 하는 파일 : "  +file.getName());
			dot.writeUTF(file.getName());
			
			int c;
			while ((c=fin.read())!=-1) {
				out.write(c);
			}
			
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

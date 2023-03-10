package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 *  TCP 방식의 통신 프로그램으로 클라이언트 역할을 한다.
 *  서버에 접속을 시도하고 접속이 완료되어
 *  서버에서 보낸 환영 메시지를 받아서 화면에 출력한다.
 */
public class TcpClient01 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		/*
		 *  통신에서 현재의 컴퓨터를 나타내는 방법
		 *  
		 *  1. 원래의 ip주소를 이용 :  예) 192.168.146.55
		 *  2. 지정된 ip주소를 이용 : 127.0.0.1 (어떤 컴퓨터든 자신의 컴터를 의미한다.)
		 *  3. 원래의 컴퓨터 이름 : 예)DESKTOP 내꺼 
		 *  4. 지정된 컴퓨터 이름 : localhost
		 */
		
		// TCP 소켓 방식으로 서버에 연결하기 위해서 Socket객체를 생성한다.
		System.out.println("서버에 연결 중입니다...");
		System.out.println();
//		Socket socket = new Socket("상대방의 ip주소",상대방의 포트 번호); 상대방(내가 접속할 서버주소)
		Socket socket = new Socket("localhost",7777);
		
		
		// 이 부분부터는 서버와 연결이 완료된 상태이여만 실행되는 코드...
		System.out.println("서버에 연결되었습니다..");
		
		/*
		 *  서버에서 보내온 메시지를 받아서 출력하기
		 *  Socket객체의 InputStream객체를 이용
		 *  (Socket의 getInputStream()매서드를 이용)
		 *  
		 *  보조 스트림 사용
		 */
		DataInputStream din = new DataInputStream(socket.getInputStream());
		
		// 메시지를 받아서 화면에 출력하기
		System.out.println("서버에서 보내온 메시지 : " + din.readUTF());
		System.out.println();
		
		// 스트림과 소켓 닫기
		din.close();
		socket.close();
		/*
		 *  실행 하려면 여기 해당 프로젝트에서 bin에 가서 cmd창 두개 연다음 
		 *  (java 패키지명클래스명) 적은다음 실행하면 된다.
		 */
	}
}

























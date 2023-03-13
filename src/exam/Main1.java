//2번 문제

package exam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main1 {
	static ArrayList<board> array = new ArrayList<>();

	public static void main(String[] args) {
		자동생성();
		
		int 번호;
		Scanner sc = new Scanner(System.in);
		System.out.println("== 프로그램 시작 ==");
		while (true) {
			String command = sc.nextLine();
//쓰기
			if (command.equals("write")) {
				System.out.println("명령어 > postwrite");

				System.out.print("제목");
				String 제목 = sc.nextLine();
				System.out.print("내용");
				String 내용 = sc.nextLine();
				String 날짜 = Util.날짜();
				

				array.add(new board(제목, 내용, 날짜));
				System.out.println(board.순서+1+ "번 글이 생성되었습니다");
				board.순서++;
				continue;
//리스트				
			} else if (command.equals("postList")) {
				System.out.println("번호 | 제목");
				for (int i=array.size()-1; i>=0; i--) {
					System.out.println(array.get(i).번호 + "|"+array.get(i).제목);
				}
				continue;
				
			} else if (command.startsWith("post detail")){
				String a[] = command.split(" ");
				board b = array.get(Integer.parseInt(a[2]));
				
				System.out.println("번호 : "+ b.번호);
				System.out.println("날짜 : "+b.날짜);
				System.out.println("제목 : "+b.제목);
				System.out.println("내용 : "+b.내용);
				
				continue;
				
			} else if (command.startsWith("post delete")){
				String a[] = command.split(" ");
				board b = array.remove(Integer.parseInt(a[2]));
				
				continue;
				
				
			}else if( command.equals("q")){
				break;
			}else {
				System.out.println("잘못된 입력");
				continue;
			}
		}
		
		System.out.println("==프로그램 종료==");
	}

	public static void 자동생성() {
		String 날짜 = Util.날짜();
		
		array.add(new board("제목1","내용",날짜));
		board.순서++;
		array.get(0).번호=board.순서;
		array.add(new board("제목2","내용",날짜));
		board.순서++;
		array.get(1).번호=board.순서;
		array.add(new board("제목3","내용",날짜));
		board.순서++;
		array.get(2).번호=board.순서;

		
	}

}

class board {
	static int 순서 =0;
	String 제목;
	String 내용;
	String 날짜;
	int 번호;
	
	public board( String 제목, String 내용, String 날짜) {
		super();
		this.제목 = 제목;
		this.내용 = 내용;
		this.날짜 = 날짜;
		번호 = 순서+1;
	}

}

class Util {

	public static String 날짜() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(calendar.getTime());
	}
}
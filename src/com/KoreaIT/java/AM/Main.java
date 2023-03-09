package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		int 순서 = 1;

		ArrayList a = new ArrayList();

		while (true) {

			Scanner sc = new Scanner(System.in);
			System.out.print("명령어 > ");
			String command = sc.nextLine();

			try {

//쓰기
				if ((command.equals("write")) || (command.equals("쓰기"))) {
					a.add(new board());
					board A = (board) a.get(순서 - 1);

					System.out.printf("제목 > ");
					String 제목 = sc.nextLine();
					System.out.printf("내용 > ");
					String 내용 = sc.nextLine();
					System.out.println();

					A.제목 = 제목;
					A.내용 = 내용;
					A.순서 = 순서;

					System.out.print("제목 : ");
					System.out.println(제목);
					System.out.print("내용 : ");
					System.out.println(내용);
					System.out.printf("%d번째 글이 생성되었습니다\n\n", 순서);
					순서++;

//종료
				} else if (command.equals("exit")) {
					break;

//읽기
				} else if (command.equals("read")) {

					// 목록 전체값 출력

					for (int i = a.size(); i > 0; i--) {
						board A_1 = (board) a.get(i - 1);
						System.out.printf("%d		/%s			/%d\n", A_1.순서, A_1.제목, A_1.조회수);
					}

					while (true) {
						
						try {
							int num = sc.nextInt();

							board A_1 = (board) a.get(num - 1);
							System.out.println(A_1.제목 + "\n" + A_1.내용);
							A_1.조회수 += 1;
							break;
						} catch (Exception e) {
							System.out.println("숫자입력 부탁 ^^..");
							continue;
						}

					}
					String accs = sc.nextLine();
//읽기 - 수정
					if (accs == "수정") {
						board ac = (board) a.get(sc.nextInt());

						if (sc.nextLine().equals("제목")) {
							ac.제목 = sc.nextLine();
						} else if (sc.nextLine().equals("내용")) {
							ac.내용 = sc.nextLine();
						}

					} else {
						continue;
					}

//게시물 개수 및 유무
				} 
				
				else if (command.equals("article list")) {
					if (순서 == 1) {
						System.out.println("게시글이 없습니다");
					} else {
						System.out.printf("게시글이 %d개 있습니다\n", 순서 - 1);
					}


				}
				
//리스트				
				else if (command.equals("list")) {

//리스트 목록
					for (int i = a.size(); i > 0; i--) {
						board A_1 = (board) a.get(i - 1);
						System.out.printf("%d		/%s			/%d\n", A_1.순서, A_1.제목, A_1.조회수);
					}

//help
				} 
				else if (command.equals("help")) {
					System.out.println();
					System.out.println("write : 글쓰기");
					System.out.println("read : 읽기");
					System.out.println("list : 리스트");
					System.out.println("article list : 목록 개수");
					System.out.println("exit : 종료");
					System.out.println();
				}
//				
				else if(command.startsWith("article detail ")) {
					
					String [] cmdDiv = command.split(" ");
					
					System.out.println(cmdDiv[2]);
					int id = Integer.parseInt(cmdDiv[2]);
					
					
					
				}
				
				else {
					System.out.println("존재하지 않는 명령어 입니다");
				}
				

// 시스템 끝

			} catch (Exception E) {
				System.out.println("오류 발생");
				E.printStackTrace();
				continue;
			}
		}

		System.out.println("==프로그램 끝==");

	}

}

// a.startsWith("~~")  >  ~~로 시작하면 true 반환


class board {
	String 제목;
	String 내용;
	int 순서;
	int 조회수;
}
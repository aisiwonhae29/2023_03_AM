package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.println(Datefx.getNowDateTimeStr());
		System.out.println("==프로그램 시작==");
		int 순서 = 1;
		
		makeTestData();
		
		ArrayList<board> a = new ArrayList<>();
		Calendar now = Calendar.getInstance();

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
					A.날짜 = Datefx.getNowDateTimeStr();

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
						} catch (InputMismatchException n) {
							System.out.println("숫자입력 부탁 ^^..");
							n.printStackTrace();
							int num = sc.nextInt();
							continue;
						} catch (Exception e) {
							System.out.println("허걱..");
							e.printStackTrace();
							sc.close();
							break;
						}

					}
					
//읽기 - 수정	
					Scanner scan1 = new Scanner(System.in);
					String correct = scan1.nextLine();
					if (correct.equals("수정")) {
						board ac = (board) a.get(sc.nextInt());
						
						
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
				} else if (command.equals("help")) {
					System.out.println();
					System.out.println("write : 글쓰기");
					System.out.println("read : 읽기");
					System.out.println("list : 리스트");
					System.out.println("article list : 목록 개수");
					System.out.println("exit : 종료");
					System.out.println();
//수정		
				} else if(command.equals("수정")) {
				
				
				
//				
				}else if (command.startsWith("article detail ")) {
					if (a.size() == 0) {
						System.out.println("게시물 없당");
						break;
					}

					String[] cmdDiv = command.split(" ");
					System.out.println(cmdDiv[2]);
					int id = Integer.parseInt(cmdDiv[2]);
					board bd = (board) a.get(id);

					boolean found = false;

					for (int i = 0; i < a.size(); i++) {
						board b = (board) a.get(i);
						if (b.순서 == id) {
							found = true;
							break;
						}
					}
					if (found) {
						System.out.printf("%d 번 %s 제목 : %s   // %s  ", id, bd.제목, bd.내용, bd.날짜);
					} else {
						break;
					}
//삭제
				} else if (command.equals("delete")) {

					System.out.println("현재" + a.size() + 1 + "개 있습니다");
					
					int dn=-1;
					
					for (int i = 0; i < a.size(); i++) {
						board cc = (board) a.get(i);
						System.out.printf("%d번 제목 : %s\n",cc.순서,cc.제목);
					}
					
					for (int i=0; i<a.size(); i++) {
						board cc = (board) a.get(i);
					}
					
					int num = sc.nextInt();
					a.remove(num-1);
					System.out.println("제거 완료");

				} else {
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
	public static void makeTestData() {
		System.out.println("테스트를 위한 데이터 생성");
		String 날짜 = Datefx.getNowDateTimeStr();
		
		
		board newdata = new board("삼국지","이야기", 0,0,날짜, 날짜);
		
		
	}

}

// a.startsWith("~~")  >  ~~로 시작하면 true 반환

class board {
	String 제목;
	String 내용;
	int 순서;
	int 조회수;
	String 날짜;
	String 수정날짜;
	
	public board(String 제목, String 내용, int 순서, int 조회수, String 날짜, String 수정날짜) {
		super();
		this.제목 = 제목;
		this.내용 = 내용;
		this.순서 = 순서;
		this.조회수 = 조회수;
		this.날짜 = 날짜;
		this.수정날짜 = 수정날짜;
	}
	
	public board() {}

}
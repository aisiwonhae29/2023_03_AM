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

			if (command.equals("article write")) {
				a.add(new board());
				board A =(board) a.get(순서-1);
				
				System.out.printf("제목 > ");
				String 제목 = sc.nextLine();
				System.out.printf("내용 > ");
				String 내용 = sc.nextLine();
				System.out.println();
				
				A.제목 = 제목;
				A.내용 = 내용;

				System.out.print("제목 : ");
				System.out.println(제목);
				System.out.print("내용 : ");
				System.out.println(내용);
				System.out.printf("%d번째 글이 생성되었습니다\n", 순서);
				순서++;

			} else if (command.equals("exit")) {
				break;

			}else if(command.equals("read")){
				int num = sc.nextInt();
				
				board A_1=(board) a.get(num-1);
				System.out.println(A_1.제목+"\n"+A_1.내용);
			
			}else if (command.equals("article list")) {
				if (순서 == 1) {
					System.out.println("게시글이 없습니다");
				} else {
					System.out.printf("게시글이 %d개 있습니다\n", 순서 - 1);
				}

			} else if(command.equals("list")){
				for (int i=0; i<순서-1; i++) {
					board A_1=(board)a.get(i);
					System.out.println(A_1.제목);
				}
				
			}else if(command.equals("help")){
				System.out.println("article write");
				System.out.println("read");
				System.out.println("list");
				System.out.println("article list");
				System.out.println("exit");
			}else {
				System.out.println("존재하지 않는 명령어 입니다");
			}

		}

		System.out.println("==프로그램 끝==");

	}

}

class board{
	String 제목;
	String 내용;
	int 순서;
}
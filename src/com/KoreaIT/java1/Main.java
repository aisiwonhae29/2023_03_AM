package com.KoreaIT.java1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Article> articles = new ArrayList<>();
	static List<member> man = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		makeTestData();

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 3;

		while (true) {

			System.out.print("명령어 > ");
			String command = sc.nextLine().trim();

			if (command.equals("exit")) {
				break;
			}

			if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다");
				} else {
					System.out.println(" 번호  //  제목    //  조회  ");
					for (int i = articles.size() - 1; i >= 0; i--) {
						Article article = articles.get(i);
						System.out.printf("  %d   //   %s   //   %d  \n", article.id, article.title, article.hit);
					}
				}

			} else if (command.equals("article write")) {
				int id = lastArticleId + 1;
				System.out.print("제목 : ");
				String regDate = Util.getNowDateTimeStr();
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, regDate, regDate, title, body);
				articles.add(article);

				System.out.printf("%d번글이 생성되었습니다\n", id);
				lastArticleId++;

			} else if (command.startsWith("article detail")) {

				String[] cmdDiv = command.split(" ");

				if (cmdDiv.length < 3) {
					System.out.println("명령어를 확인해주세요");
					continue;
				}

				int id = Integer.parseInt(cmdDiv[2]);

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}

				foundArticle.hit++;

				System.out.println("번호 : " + foundArticle.id);
				System.out.println("작성날짜 : " + foundArticle.regDate);
				System.out.println("수정날짜 : " + foundArticle.updateDate);
				System.out.println("제목 : " + foundArticle.title);
				System.out.println("내용 : " + foundArticle.body);
				System.out.println("조회 : " + foundArticle.hit);

			} else if (command.startsWith("article modify")) {

				String[] cmdDiv = command.split(" ");

				if (cmdDiv.length < 3) {
					System.out.println("명령어를 확인해주세요");
					continue;
				}

				int id = Integer.parseInt(cmdDiv[2]);

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}
				System.out.print("새 제목 : ");
				String updateDate = Util.getNowDateTimeStr();
				String newTitle = sc.nextLine();
				System.out.print("새 내용 : ");
				String newBody = sc.nextLine();

				foundArticle.title = newTitle;
				foundArticle.body = newBody;
				foundArticle.updateDate = updateDate;

				System.out.println(id + "번 글을 수정했습니다");

			} else if (command.startsWith("article delete")) {

				String[] cmdDiv = command.split(" ");

				if (cmdDiv.length < 3) {
					System.out.println("명령어를 확인해주세요");
					continue;
				}

				int id = Integer.parseInt(cmdDiv[2]);

				int foundIndex = getArticleIndexById(id);

				if (foundIndex == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}

				articles.remove(foundIndex);
				System.out.println(id + "번 글을 삭제했습니다");

			} else if (command.startsWith("회원가입")) {
				while (true) {
					System.out.println("id 입력 > ");
					String id = sc.nextLine();
					if (회원가입(id)) {
					} else {
						break;
					}
					System.out.println("Pw 입력 > ");
					String pw = sc.nextLine();
					if(회원가입(pw)) {
					}else {
						break;
					}
					
					System.out.println("성별 입력 > ");
					String sex = sc.nextLine();
					System.out.println("나이 입력 > ");
					int age = sc.nextInt();
					String 날짜 = Util.getNowDateTimeStr();
					man.add(new member(id, command, sex, age, 날짜));
					break;
				}

				

				

			} else {
				System.out.println("존재하지 않는 명령어입니다");
			}
		}

		System.out.println("==프로그램 끝==");

		sc.close();
	}

	private static int getArticleIndexById(int id) {
		int i = 0;
		for (Article article : articles) {
			if (article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private static Article getArticleById(int id) {

		int index = getArticleIndexById(id);

		if (index != -1) {
			return articles.get(index);
		}

		return null;
	}

	private static void makeTestData() {

		System.out.println("테스트를 위한 데이터를 생성합니다");
		articles.add(new Article(1, Util.getNowDateTimeStr(), Util.getNowDateTimeStr(), "제목1", "제목1", 11));
		articles.add(new Article(2, Util.getNowDateTimeStr(), Util.getNowDateTimeStr(), "제목2", "제목2", 22));
		articles.add(new Article(3, Util.getNowDateTimeStr(), Util.getNowDateTimeStr(), "제목3", "제목3", 33));
	}

	private static boolean 회원가입(Object b) {

		for (member d : man) {
			if (d.Id.equals(b)) {
				System.out.println("id 중복");
				return false;
			} else if (!(d.Pw.equals(b))) {
				System.out.println("Pw가 같지 않습니다");
				return false;
			} else {
				return true;
			}

		}
		return true;
	}

}

class member {
	int 순서 = 1;
	String Id;
	String Pw;
	String 성별;
	String 이름;
	int 나이;
	String regdate;

	public member(String id, String pw, String 이름, int 나이, String regdate) {
		super();
		Id = id;
		Pw = pw;
		성별 = "남";
		this.이름 = 이름;
		this.나이 = 나이;
		this.regdate = regdate;
	}

}

class Article {
	int id;
	String regDate;
	String updateDate;
	String title;
	String body;
	int hit;

	Article(int id, String regDate, String updateDate, String title, String body) {
		this(id, regDate, updateDate, title, body, 0);
	}

	Article(int id, String regDate, String updateDate, String title, String body, int hit) {
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.title = title;
		this.body = body;
		this.hit = hit;
	}
}

package board;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	ArrayList<Article> articles = new ArrayList<>();
	int no = 1; // 게시물 번호
	// Integer은 숫자
	Scanner sc = new Scanner(System.in);

	public void runBoard() {

		// 명령어를 입력해주세요 : (출력) help(입력)
		// add  : 게시물 등록 (출력)
		// list : 게시물 목록 조회 (출력)
		// 명령어를 입력해주세요 : (출력) add(입력)
		
		
		while(true) {
			System.out.println("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();				
			if(cmd.equals("help")) {
				printHelp();
			}else if(cmd.equals("add")) {
				// 중복되지 않아야 된다. 자동으로 만들어 줘야 된다.
				addArticle();	
			}else if(cmd.equals("list")) {
				list();

			}else if(cmd.equals("update")) {
				
				updateArticle();
				
			} 		else if(cmd.equals("delete")) {
				deleteArticle();
			}
		}	
	}
	

	
	
	
	private void deleteArticle() {
		System.out.println("삭제할 게시물 번호: ");
		int targetNo = Integer.parseInt(sc.nextLine());
		
		int targetIndex = getIndexOfArticleNo(targetNo);
	
		if(targetIndex == -1) {
			System.out.println("없는 게시물입니다.");
		}else{
			articles.remove(targetIndex);
			System.out.println("삭제가 완료되었습니다.");
			list();
		}	
		
	}


	public int getIndexOfArticleNo(int targetNo) {
		
		for(int i = 0; i < articles.size(); i++) {
			Article currentArticle = articles.get(i);
			if(targetNo == currentArticle.id){
				return i;
			}
			
		}
		
		return -1;
	}
	
	
	
	private void list() {
		for(int i = 0; i < articles.size();i++) {
			
			Article article = articles.get(i);
			
			System.out.println("번호 : " + article.id);
			System.out.println("제목 : " + article.title);
			System.out.println("내용 : " + article.body);
			System.out.println("=====================");
		}
	}
	
	private void printHelp() {
		System.out.println("add : 게시물 등록");
		System.out.println("list : 게시물 목록 조회");
		System.out.println("update : 게시물 수정");
		System.out.println("delete : 게시물 삭제");
		System.out.println("search : 게시물 검색");
	}
	
	private void addArticle() {
		System.out.println("제목 입력해주세요 : ");
		String title = sc.nextLine();
		System.out.println("내용을 입력해주세요 : ");
		String body = sc.nextLine();

		Article article = new Article(no, title, body);
		
		articles.add(article);
		
		System.out.println("게시물이 저장되었습니다.");	
		no++; // 번호 자동 증가
	}
	
	private void updateArticle() {
		System.out.println("수정할 게시물 번호: ");
		int targetNo = Integer.parseInt(sc.nextLine());
		
		int targetIndex = getIndexOfArticleNo(targetNo);
	
		if(targetIndex == -1) {
			System.out.println("없는 게시물입니다.");
		}else{
			System.out.println("새제목 : ");
			String title = sc.nextLine();
			System.out.println("새내용 : ");
			String body = sc.nextLine();

			Article article = new Article(targetNo, title, body);
			
			articles.set(targetIndex, article);
			
			System.out.println("수정이 완료되었습니다.");
			list();
		}	
	}
	

}

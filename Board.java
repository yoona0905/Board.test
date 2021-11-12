package board;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	ArrayList<String> titles = new ArrayList<>();
	ArrayList<String> bodies = new ArrayList<>();
	ArrayList<Integer> numbers = new ArrayList<>();
	int no = 1; // 게시물 번호
	// Integer은 숫자

	public void runBoard() {

		// 명령어를 입력해주세요 : (출력) help(입력)
		// add  : 게시물 등록 (출력)
		// list : 게시물 목록 조회 (출력)
		// 명령어를 입력해주세요 : (출력) add(입력)
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();
			
			
			if(cmd.equals("help")) {
				System.out.println("add : 게시물 등록");
				System.out.println("list : 게시물 목록 조회");
				System.out.println("update : 게시물 수정");
				System.out.println("delete : 게시물 삭제");
			}else if(cmd.equals("add")) {
				
				// 중복되지 않아야 된다. 자동으로 만들어 줘야 된다.
				
				
				numbers.add(no);
				System.out.println("제목 입력해주세요 : ");
				String title = sc.nextLine();
				System.out.println("내용을 입력해주세요 : ");
				String body = sc.nextLine();
				
				titles.add(title);
				bodies.add(body);
				
				System.out.println("게시물이 저장되었습니다.");	
				no++; // 번호 자동 증가
			}else if(cmd.equals("list")) {
				list();

			}else if(cmd.equals("update")) {
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

					titles.set(targetIndex, title);
					bodies.set(targetIndex, body);
					System.out.println("수정이 완료되었습니다.");
					list();
				}	
			} 		else if(cmd.equals("delete")) {
				System.out.println("삭제할 게시물 번호: ");
				int targetNo = Integer.parseInt(sc.nextLine());
				
				int targetIndex = getIndexOfArticleNo(targetNo);
			
				if(targetIndex == -1) {
					System.out.println("없는 게시물입니다.");
				}else{
					titles.remove(targetIndex);
					bodies.remove(targetIndex);
					numbers.remove(targetIndex);
					System.out.println("삭제가 완료되었습니다.");
					list();
				}	
			}
		}	
	}
	
	public int getIndexOfArticleNo(int targetNo) {
		
		for(int i = 0; i < numbers.size(); i++) {
			int currentNo = numbers.get(i);
			if(targetNo == currentNo){
				return i;
			}
			
		}
		
		return -1;
	}
	
	
	
	public void list() {
		for(int i = 0; i < titles.size();i++) {
			
			int ano = numbers.get(i);
			String title = titles.get(i);
			String body = bodies.get(i);
			
			System.out.println("번호 : " + ano);
			System.out.println("제목 : " + title);
			System.out.println("내용 : " + body);
			System.out.println("=====================");
		}
	}

}

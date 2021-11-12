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
				int target = Integer.parseInt(sc.nextLine());
				
				
				int targetIndex = -1;
				
				for(int i = 0; i < numbers.size(); i++) {
					int currentNo = numbers.get(i);
					if(target == currentNo){
						targetIndex = i;
						break;
					}
					
				}
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
				
			}
			
		}
		
		// 제목을 입력해주세요 : (출력) 안녕하세요(입력)
		// 내용을 입력해주세요 : (출력) 반갑습니다(입력)
		// 게시물이 저장되었습니다. (출력)
		// 명령어를 입력해주세요 : (출력) list(입력)
		// 번호 : 1(출력)
		// 제목 : 안녕하세요(출력)
		// 내용 : 반갑습니다(출력)
		// ====================================(출력)
		// 명령어를 입력해주세요 : (출력) add(입력)
		// 제목을 입력해주세요 : (출력) 안녕하세요2(입력)
		// 내용을 입력해주세요 : (출력) 반갑습니다2(입력)
		// 게시물이 저장되었습니다. (출력)
		// 명령어를 입력해주세요 : (출력) list(입력)
		// 번호 : 1(출력)
		// 제목 : 안녕하세요(출력)
		// 내용 : 반갑습니다(출력)
		// ====================================(출력)
		// 번호 : 2(출력)
		// 제목 : 안녕하세요2(출력)
		// 내용 : 반갑습니다2(출력)
		// ====================================(출력)
		
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

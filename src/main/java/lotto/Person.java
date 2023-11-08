package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Person {
	private List<List<Integer>> lottoTicket = new ArrayList<>();
	
	public void buyLotto(LottoMachine lottoMachine) {
		System.out.println("구입금액을 입력해주세요");
		int pay = Integer.parseInt(Console.readLine());
		for(int i=0; i<pay/1000; i++) {
			List<Integer> numbers = lottoMachine.generateLottoTicket();
			lottoTicket.add(numbers);
		}
	}
	
	public void displayTicket() {
	    System.out.println(lottoTicket.size() + "개를 구매했습니다.");
	    for (List<Integer> ticket : lottoTicket) {
	    	ticket.sort(null);
	        System.out.println(ticket);
	    }
	}
	public int compareNum(List<Integer> ticket, List<Integer> winnigNumbers) {
		int count = 0;
		for(int number : ticket) {
			if(winnigNumbers.contains(number)) {
				count++;
			}
		}
		return count;
	}
	
	public void displayResult(int count) {
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + count + "개");
		System.out.println("4개 일치 (50,000원) - " + count + "개");
		System.out.println("5개 일치 (1,500,000원) - " + count + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");
	}
	
	public List<List<Integer>> getLottoTicket(){
		return lottoTicket;
	}
}

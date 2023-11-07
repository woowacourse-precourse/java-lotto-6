package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Person {
	private int pay;
	private List<List<Integer>> lottoTicket = new ArrayList<>();
	
	public Person() { }
	
	public void buyLotto(LottoMachine lottoMachine) {
		System.out.println("구입금액을 입력해주세요");
		pay = Integer.parseInt(Console.readLine());
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
}

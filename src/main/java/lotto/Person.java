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
	

}


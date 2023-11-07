package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.view.Printer;
import lotto.view.UserInput;

public class GameController {
	
	Printer printer = new Printer();
	UserInput input = new UserInput();
	
	List<Integer> numbers = new ArrayList<Integer>();
	Lotto lotto = new Lotto(numbers);
	
	public void playLotto() {
		printer.printDirection("구입금액을 입력해 주세요.\n");
		int getUserMoney = input.getMoney();
		int tickets = lotto.countLottoTickets(getUserMoney);
		
		List<List<Integer>> totalTickets = lotto.createLottoTickets(tickets);
		printer.printLottoTickets(tickets, totalTickets);
		
		
		
		
	}
}

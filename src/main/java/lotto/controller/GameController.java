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
		
		printer.printDirection("\n당첨 번호를 입력해 주세요.\n");
		List<Integer> winnersNumbersByUser = input.getWinnersNumbers();
		
		printer.printDirection("\n보너스 번호를 입력해 주세요.\n");
		int bonusNumberByUser = input.getBonusNumber(winnersNumbersByUser);
		
		//테스트
		//System.out.println("당첨번호는" + winnersNumbersByUser);
		//System.out.println("보너스 넘버는" + bonusNumberByUser);
		
		
		
	}
}

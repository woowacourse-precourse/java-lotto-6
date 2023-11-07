package lotto.Controller;

import camp.nextstep.edu.missionutils.*;
import java.util.List;
import lotto.*;
//import lotto.Domain.Budget;
//import lotto.Domain.Ticket;
import lotto.Domain.*;
//import lotto.Domain.Lotto_Number;
import lotto.View.InputView;
import lotto.View.OutputView;



public class Game{
	
	//private Lotto lotto;
	
	public void run() {
		start();
	}

	
	

	
	
	public static void start() {
		double a = 1.14;
		Tickets tickets;
		//자본금입력//
		OutputView.Print_Budget_Message();
		Budget budget = new Budget(InputView.Input_Budget());
		//구매수량 출력//
		OutputView.Print_Purchase_Message(budget.get_Count());
		//티켓 출력//
		//Ticket ticket = new Ticket();
		//System.out.println(ticket.getNumber());
		tickets = new Tickets(budget.get_Count());
		
		//로또번호입력//
		OutputView.Print_Lotto_Input_Message();
		Lotto_Number lotto_number = new Lotto_Number();
		OutputView.Print_Bonus_Input_Message();
		lotto_number.Bonus_number();
		//로또계산//
		tickets.Win_Tickets(lotto_number.get_Lotto(), lotto_number.get_Bonus());
		//총 통계//
		Roe roe = new Roe(tickets.get_Wins(),tickets.get_Purchase_Number());
		OutputView.Print_Stats_Message();
		OutputView.Print_RankFive_Message(1);
		OutputView.Print_RankFour_Message(1);
		OutputView.Print_RankThree_Message(1);
		OutputView.Print_RankTwo_Message(1);
		OutputView.Print_RankOne_Message(1);
		OutputView.Print_Roe_Message(a);
	}
}


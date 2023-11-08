package lotto.Controller;

import lotto.Domain.*;
import lotto.View.*;


public class Game{
	Budget budget;
	Tickets tickets;
	Lotto_Number lotto_number;
	Roe roe;
	
	public Game() {
		
		budget = Cash_In();
		tickets =Ticket_Issue(budget.get_Count());
		lotto_number = Lotto_Lots(tickets);
		tickets.Win_Tickets(lotto_number.get_Lotto(), lotto_number.get_Bonus());
		roe = Fianl_Roe(tickets);
		Print_Result(roe);
		
		//start();
	}
	
	
	public static void start() {
//		Tickets tickets;
//		Lotto_Number lotto_number;
//		Budget budget;
//		Roe roe;
//		
//		
//		//자본금입력//
//		OutputView.Print_Budget_Message();
//		budget = new Budget(InputView.Input_Budget());
//		//구매수량 출력//
//		OutputView.Print_Purchase_Message(budget.get_Count());
//		//티켓 출력//
//		tickets = new Tickets(budget.get_Count());
//		
//		//로또번호입력//
//		OutputView.Print_Lotto_Input_Message();
//		
//		lotto_number = new Lotto_Number();
//		OutputView.Print_Bonus_Input_Message();
//		lotto_number.Bonus_number();
//		//로또계산//
//		tickets.Win_Tickets(lotto_number.get_Lotto(), lotto_number.get_Bonus());
//		//총 통계//
//		roe = new Roe(tickets.get_Wins(),tickets.get_Purchase_Number());
//		OutputView.Print_Stats_Message();
//		OutputView.Print_RankFive_Message(roe.get_Win_Count(Roe.Ranking.RankFive.Index()));
//		OutputView.Print_RankFour_Message(roe.get_Win_Count(Roe.Ranking.RankFour.Index()));
//		OutputView.Print_RankThree_Message(roe.get_Win_Count(Roe.Ranking.RankThree.Index()));
//		OutputView.Print_RankTwo_Message(roe.get_Win_Count(Roe.Ranking.RankTwo.Index()));
//		OutputView.Print_RankOne_Message(roe.get_Win_Count(Roe.Ranking.RankOne.Index()));
//		OutputView.Print_Roe_Message(roe.get_Roe());
	}
	private Budget Cash_In() {
		//자본금입력//
		//OutputView.Print_Budget_Message();
		Budget budget = new Budget();
		System.out.println(budget.get_Cash());
		//구매수량 출력//
		OutputView.Print_Purchase_Message(budget.get_Count());
		return budget;
	}
	private Tickets Ticket_Issue_old(Budget budget) {
		//티켓 출력//
		Tickets tickets = new Tickets(budget.get_Count());
		return tickets;
	}
	
	public Tickets Ticket_Issue(Integer Purchase_Number) {
		Tickets tickets = new Tickets(Purchase_Number);
		for (int i = 0 ; i<Purchase_Number; i++) {
			Ticket ticket = new Ticket();
			System.out.println(ticket.getNumber());
			tickets.add(ticket);
			
		}
		return tickets;
	}
//	}
	
	private Lotto_Number Lotto_Lots(Tickets tickets) {
		OutputView.Print_Lotto_Input_Message();
		Lotto_Number lotto = new Lotto_Number();
		OutputView.Print_Bonus_Input_Message();
		lotto.Bonus_number();
		//tickets.Win_Tickets(lotto.get_Lotto(), lotto.get_Bonus());
		return lotto;
	}
	private Roe Fianl_Roe(Tickets tickets) {
		Roe roe = new Roe(tickets.get_Wins(),tickets.get_Purchase_Number());

		return roe;
	}
	private void Print_Result(Roe roe) {
		OutputView.Print_Stats_Message();
		OutputView.Print_RankFive_Message(roe.get_Win_Count(Roe.Ranking.RankFive.Index()));
		OutputView.Print_RankFour_Message(roe.get_Win_Count(Roe.Ranking.RankFour.Index()));
		OutputView.Print_RankThree_Message(roe.get_Win_Count(Roe.Ranking.RankThree.Index()));
		OutputView.Print_RankTwo_Message(roe.get_Win_Count(Roe.Ranking.RankTwo.Index()));
		OutputView.Print_RankOne_Message(roe.get_Win_Count(Roe.Ranking.RankOne.Index()));
		OutputView.Print_Roe_Message(roe.get_Roe());
	}
}


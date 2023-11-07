package lotto.Controller;

import lotto.Domain.*;
import lotto.View.*;


public class Game{
	
	
	public void run() {
		start();
	}
	
	
	public static void start() {
		Tickets tickets;
		//자본금입력//
		OutputView.Print_Budget_Message();
		Budget budget = new Budget(InputView.Input_Budget());
		//구매수량 출력//
		OutputView.Print_Purchase_Message(budget.get_Count());
		//티켓 출력//
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
		OutputView.Print_RankFive_Message(roe.get_Win_Count(Roe.Ranking.RankFive.Index()));
		OutputView.Print_RankFour_Message(roe.get_Win_Count(Roe.Ranking.RankFour.Index()));
		OutputView.Print_RankThree_Message(roe.get_Win_Count(Roe.Ranking.RankThree.Index()));
		OutputView.Print_RankTwo_Message(roe.get_Win_Count(Roe.Ranking.RankTwo.Index()));
		OutputView.Print_RankOne_Message(roe.get_Win_Count(Roe.Ranking.RankOne.Index()));
		OutputView.Print_Roe_Message(roe.get_Roe());
	}
}


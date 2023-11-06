package view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import controller.InputMoney;
import controller.InputNumbers;
import controller.RunGame;
import controller.Statistics;
import lotto.Lotto;

import static model.Data.*;

public class Viewer {
	
	private RunGame run=new RunGame();
	private Announcer announcer=new Announcer();
	private InputMoney money_in=new InputMoney();
	private InputNumbers numbers_in=new InputNumbers();

	private List<List<Integer>> lottery_list;
	private Lotto lotto;
	private int bonus;
	
	private Statistics stat;
	
	private int [] classify;
	
	public Viewer() {
		purchaseGuide();
		numbersGuide();
		statisticsGuide();
	}
	
	private void purchaseGuide() {
		announcer.purchase_guidance();
		int lotto_count=money_in.purchase_lotto()/UNIT_PRICE;
		announcer.feedback_purchase(lotto_count);
		
		issueGuide(lotto_count);
	}
	
	private void issueGuide(int lotto_count) {
		lottery_list=run.issueGuide(lotto_count);
		
		for(List<Integer> lottery:lottery_list) {
			System.out.println(lottery);
		}
	}
	
	private void numbersGuide() {
		announcer.winning_num_guidance();
		String num_input=Console.readLine();
		lotto=numbers_in.select_numbers(num_input);
		
		announcer.bonus_guidance();
		String bonus_input=Console.readLine();
		bonus=numbers_in.select_bonus(bonus_input);
		
		stat=new Statistics(lottery_list, bonus, lotto);
	}
	
	private void statisticsGuide() {
		announcer.statistics_start();
		classify=stat.compareNumbers();
		announcer.announceResult(classify);
		
		int winnings=stat.getProfitAmount(classify);
		double rate=stat.getRateOfReturn(winnings);
		announcer.announce_rate(rate);
	}
}

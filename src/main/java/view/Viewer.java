package view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import controller.InputMoney;
import controller.InputNumbers;
import controller.RunGame;
import controller.Statistics;
import lotto.Lotto;
import model.Data;

import static model.FixedValues.*;

public class Viewer {
	
	private Data data=new Data();
	private RunGame run=new RunGame();
	private Announcer announcer=new Announcer();
	
	private Statistics stat;
	
	private int [] classify;
	
	public Viewer() {
		purchaseGuide();
		numbersGuide();
		statisticsGuide();
	}
	
	private void purchaseGuide() {
		announcer.purchase_guidance();
		data.setLottoCount();
		announcer.feedback_purchase(data.getLottoCount());
		
		issueGuide();
	}
	
	private void issueGuide() {
		data=run.issueGuide(data);
		
		for(List<Integer> lottery:data.getLottoList()) {
			System.out.println(lottery);
		}
	}
	
	private void numbersGuide() {
		announcer.winning_num_guidance();
		String num_input=Console.readLine();
		data.setLotto(num_input);
		
		announcer.bonus_guidance();
		String bonus_input=Console.readLine();
		data.setBonus(bonus_input);
		
		stat=new Statistics(data);
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

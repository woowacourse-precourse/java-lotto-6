package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import static model.Data.*;

public class RunGame {
	
	private static int lotto_count;
	private static List<List<Integer>> lottery_list=new ArrayList<List<Integer>>();
	//private static List<Integer> winning_nums;
	private static int bonus;
	
	private Lotto lotto;
	
	/*public RunGame() {
		guidance();
		new Statistics(lottery_list, bonus, lotto);
	}
	
	private void guidance() {
		purchaseGuide();
		issueGuide();
		numbersGuide();
	}
	
	private void purchaseGuide() {
		lotto_count=money_in.purchase_lotto()/UNIT_PRICE;
	}*/
	
	public List<List<Integer>> issueGuide(int lotto_count) {		
		for(int i=0;i<lotto_count;i++) {
			issueTickets();
		}
		return lottery_list;
	}
	
	private void issueTickets() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, CORRECT_CNT);
		//Collections.sort(numbers);
		
		lottery_list.add(numbers);
	}
	
	/*public void numbersGuide() {
		System.out.println("당첨 번호를 입력해 주세요.");
		String num_input=Console.readLine();
		lotto=numbers_in.select_numbers(num_input);
		
		System.out.println("\n보너스 번호를 입력해 주세요.");
		String bonus_input=Console.readLine();
		bonus=numbers_in.select_bonus(bonus_input);
	}*/
}

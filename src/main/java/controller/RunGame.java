package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import static model.Data.*;

public class RunGame {
	
	private final InputMoney money_in=new InputMoney();
	private final InputNumbers numbers_in=new InputNumbers();
	
	private static int lotto_count;
	private static List<List<Integer>> lottery_list=new ArrayList<List<Integer>>();
	private static List<Integer> winning_nums;
	private static int bonus;
	
	
	
	public RunGame() {
		guidance();
		new Statistics(lottery_list, winning_nums, bonus);
	}
	
	private void guidance() {
		purchaseGuide();
		issueGuide();
		numbersGuide();
	}
	
	private void purchaseGuide() {
		System.out.println("구입금액을 입력해 주세요.");
		
		lotto_count=money_in.purchase_lotto()/UNIT_PRICE;
		System.out.println("\n"+lotto_count+"개를 구매했습니다.");
	}
	
	private void issueGuide() {
		for(int i=0;i<lotto_count;i++) {
			issueTickets();
		}
	}
	
	private void issueTickets() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, CORRECT_CNT);
		//Collections.sort(numbers);
		
		lottery_list.add(numbers);
		System.out.println(numbers);
	}
	
	private void numbersGuide() {
		System.out.println("당첨 번호를 입력해 주세요.");
		winning_nums=numbers_in.select_numbers();
		
		System.out.println("\n보너스 번호를 입력해 주세요.");
		bonus=numbers_in.select_bonus();
	}
}

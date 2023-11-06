package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import static model.Data.*;

public class RunGame {
	
	private final InputMoney money_in=new InputMoney();
	private final InputNumbers numbers_in=new InputNumbers();
	
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
	}*/
	
	public void purchaseGuide() {
		//System.out.println("구입금액을 입력해 주세요.");
		
		lotto_count=money_in.purchase_lotto()/UNIT_PRICE;
		//System.out.println("\n"+lotto_count+"개를 구매했습니다.");
	}
	
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
		//System.out.println(numbers);
	}
	
	public void numbersGuide() {
		System.out.println("당첨 번호를 입력해 주세요.");
		lotto=numbers_in.select_numbers();
		
		System.out.println("\n보너스 번호를 입력해 주세요.");
		bonus=numbers_in.select_bonus();
	}
}

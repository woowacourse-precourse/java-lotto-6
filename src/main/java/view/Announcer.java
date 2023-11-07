package view;

import static model.FixedValues.*;

public class Announcer {

	public void purchase_guidance() {
		System.out.println(PURCHASE_GUIDE);
	}
	
	public void feedback_purchase(int lotto_count) {
		System.out.println("\n"+lotto_count+"개를 구매했습니다.");
	}
	
	public void winning_num_guidance() {
		System.out.println(WINNGIN_NUM_GUIDE);
	}
	
	public void bonus_guidance() {
		System.out.println(BONUS_GUIDE);
	}
	
	public void statistics_start() {
		System.out.println(STATISTICS_START);
	}
	
	public void announceResult(int [] classify) {
		System.out.println(CORRESPONDING_THREE+classify[0]+"개");
		System.out.println(CORRESPONDING_FOUR+classify[1]+"개");
		System.out.println(CORRESPONDING_FIVE+classify[2]+"개");
		System.out.println(CORRESPONDING_BONUS+classify[3]+"개");
		System.out.println(CORRESPONDING_ALL+classify[4]+"개");
	}
	
	public void announce_rate(double rate) {
		System.out.println("총 수익률은 "+String.format("%,.1f", rate)+"%입니다.");
	}
}

package controller;

import java.util.List;

import lotto.Lotto;

import static model.Data.*;

public class Statistics {

	private List<List<Integer>> lottery_list;
	//private List<Integer> winning_nums;
	private int bonus;
	private Lotto lotto;
	
	private static int [] classify= {0,0,0,0,0};
	
	public Statistics(List<List<Integer>> lottery_list,int bonus,Lotto lotto) {
		this.lottery_list=lottery_list;
		//this.winning_nums=winning_nums;
		this.bonus=bonus;
		this.lotto=lotto;
		//System.out.println("당첨 통계\n---");
		//getStatistics();
	}
	
	/*private void getStatistics() {
		compareNumbers();
		//announceResult();
		int winnings=getProfitAmount();
		getRateOfReturn(winnings);
	}*/
	
	/*private void compareNumbers() {		
		for(List<Integer> nums:lottery_list) {
			int cnt=countMathcingNums(nums);
			boolean lucky=luckyThough(nums);
			classifyWinningTypes(cnt, lucky);
		}
	}*/
	
	public int [] compareNumbers() {	
		int [] arr=new int[CORRECT_CNT];
		for(List<Integer> nums:lottery_list) {
			int cnt=countMatchingNums(nums);
			boolean lucky=luckyThough(nums);
			arr=classifyWinningTypes(cnt, lucky);
		}
		return arr;
	}
	
	public double getRateOfReturn(int winnings) {
		double rate=winnings*100.0/(lottery_list.size()*UNIT_PRICE);
		//System.out.println("총 수익률은 "+String.format("%,.1f", rate)+"%입니다.");
		return rate;
	}
	
	public int getProfitAmount(int [] classify) {
		int winnings=0;
		
		winnings+=classify[0]*MATCHING_THREE;
		winnings+=classify[1]*MATCHING_FOUR;
		winnings+=classify[2]*MATCHING_FIVE;
		winnings+=classify[3]*WITH_BONUS;
		winnings+=classify[4]*MATCHING_ALL;
		
		return winnings;
	}
	
	private int [] classifyWinningTypes(int cnt,boolean lucky) {
		if(cnt==3) {classify[0]=classify[0]+1;}
		if(cnt==4) {classify[1]=classify[1]+1;}
		if(cnt==5&&!lucky) {classify[2]=classify[2]+1;}
		if(cnt==5&&lucky) {classify[3]=classify[3]+1;}
		if(cnt==6) {classify[4]=classify[4]+1;}
		//announceResult();
		
		return classify;
	}
	
	/*private void announceResult() {
		System.out.println("3개 일치 (5,000원) - "+classify[0]+"개");
		System.out.println("4개 일치 (50,000원) - "+classify[1]+"개");
		System.out.println("5개 일치 (1,500,000원) - "+classify[2]+"개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+classify[3]+"개");
		System.out.println("6개 일치 (2,000,000,000원) - "+classify[4]+"개");
	}*/
	
	private int countMatchingNums(List<Integer> nums) {
		int cnt=INIT_CNT;
		
		for(int n:lotto.getLottoNumbers()) {
			if(nums.contains(n)) {
				cnt++;
			}
		}
		return cnt;
	}
	
	private boolean luckyThough(List<Integer> nums) {
		if(nums.contains(bonus)) {
			return true;
		}
		return false;
	}
}

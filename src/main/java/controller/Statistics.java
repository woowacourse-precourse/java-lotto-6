package controller;

import java.util.List;

import lotto.Lotto;
import model.Data;

import static model.FixedValues.*;

public class Statistics {

	private Data data;
	
	private static int [] classify= {0,0,0,0,0};
	
	public Statistics(Data data) {
		this.data=data;
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
		int [] mathcing_types=new int[CORRECT_CNT];
		
		for(List<Integer> nums:data.getLottoList()) {
			int cnt=countMatchingNums(nums);
			boolean lucky=luckyThough(nums);
			mathcing_types=classifyWinningTypes(cnt, lucky);
		}
		return mathcing_types;
	}
	
	public double getRateOfReturn(int winnings) {
		double rate=winnings*100.0/(data.getLottoList().size()*UNIT_PRICE);
		
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

	private int countMatchingNums(List<Integer> nums) {
		int cnt=INIT_CNT;
		
		for(int n:data.getLotto().getLottoNumbers()) {
			if(nums.contains(n)) {
				cnt++;
			}
		}
		return cnt;
	}
	
	private boolean luckyThough(List<Integer> nums) {
		if(nums.contains(data.getBonus())) {
			return true;
		}
		return false;
	}
}

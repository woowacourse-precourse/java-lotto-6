package features;

import java.util.List;

import model.Data;

import static model.FixedValues.*;

public class Statistics {

	private Data data;
	
	private int [] classify= {0,0,0,0,0};
	
	public Statistics(Data data) {
		this.data=data;
	}

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
		int howManyDidIBought=data.getLottoList().size();
		
		return winnings*PARSING_TO_DOUBLE_PERCENTAGE/(howManyDidIBought*UNIT_PRICE);
	}
	
	public int getProfitAmount(int [] classify) {
		int winnings=INIT_CNT;
		
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
	
	
	//test용도
	public int forMathcingTest(List<Integer> test_list,List<Integer> compared) {
		int cnt=INIT_CNT;
		
		for(int n:compared) {
			if(test_list.contains(n)) {
				cnt++;
			}
		}
		return cnt;
	}
	public boolean forBonusTest(List<Integer> test_list) {
		if(test_list.contains(data.getBonus())) {
			return true;
		}
		return false;
	}
	public int [] forCountingTest(int test_cnt,boolean bonus_existence,int [] test_arr) {
		if(test_cnt==3) {test_arr[0]=test_arr[0]+1;}
		if(test_cnt==4) {test_arr[1]=test_arr[1]+1;}
		if(test_cnt==5&&!bonus_existence) {test_arr[2]=test_arr[2]+1;}
		if(test_cnt==5&&bonus_existence) {test_arr[3]=test_arr[3]+1;}
		if(test_cnt==6) {test_arr[4]=test_arr[4]+1;}
		
		return test_arr;
	}
	public int forProfitTest(int [] test_arr) {
		int test_get=INIT_CNT;
		test_get+=test_arr[0]*MATCHING_THREE;
		test_get+=test_arr[1]*MATCHING_FOUR;
		test_get+=test_arr[2]*MATCHING_FIVE;
		test_get+=test_arr[3]*WITH_BONUS;
		test_get+=test_arr[4]*MATCHING_ALL;
		
		return test_get;
	}
	public double forRateTest(int test_get) {
		int test_bought=data.getLottoList().size();
		
		return test_get*PARSING_TO_DOUBLE_PERCENTAGE/(test_bought*UNIT_PRICE);
	}
}

package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import static lotto.system.Constant.FIRST_RANK;
import static lotto.system.Constant.SECOND_RANK;
import static lotto.system.Constant.THIRD_RANK;
import static lotto.system.Constant.FOURTH_RANK;
import static lotto.system.Constant.LAST_RANK;
import static lotto.system.Constant.FIRST_RANK_PRIZE;
import static lotto.system.Constant.SECOND_RANK_PRIZE;
import static lotto.system.Constant.THIRD_RANK_PRIZE;
import static lotto.system.Constant.FOURTH_RANK_PRIZE;
import static lotto.system.Constant.LAST_RANK_PRIZE;

public class Earning {
	int firstRankCount;
	int secondRankCount;
	int thirdRankCount;
	int fourthRankCount;
	int fifthRankCount;
	
	public Earning(List<Integer> result) {
		this.firstRankCount = result.get(FIRST_RANK.getconstant()-1);
		this.secondRankCount = result.get(SECOND_RANK.getconstant()-1);
		this.thirdRankCount = result.get(THIRD_RANK.getconstant()-1);
		this.fourthRankCount = result.get(FOURTH_RANK.getconstant()-1);
		this.fifthRankCount = result.get(LAST_RANK.getconstant()-1);
	}
	
	public int getRankCount(int n) {
		if(n==FIRST_RANK.getconstant())
			return firstRankCount;
		if (n==SECOND_RANK.getconstant())
			return secondRankCount;
		if (n==THIRD_RANK.getconstant())
			return thirdRankCount;
		if (n==FOURTH_RANK.getconstant())
			return fourthRankCount; 
		return fifthRankCount; 
	}
	
	public float calculateEarningRate(int amount) {
		float sum = 0;
		for (int i=FIRST_RANK.getconstant(); i<=LAST_RANK.getconstant(); i++) {
			sum += getRankCount(i) * getRankPrize(i);
		}
		return calculateRate(sum, amount);
	}
	
	private int getRankPrize(int n) {
		if(n==FIRST_RANK.getconstant())
			return FIRST_RANK_PRIZE.getconstant();
		if (n==SECOND_RANK.getconstant())
			return SECOND_RANK_PRIZE.getconstant();
		if (n==THIRD_RANK.getconstant())
			return THIRD_RANK_PRIZE.getconstant();
		if (n==FOURTH_RANK.getconstant())
			return FOURTH_RANK_PRIZE.getconstant(); 
		return LAST_RANK_PRIZE.getconstant(); 
	}
	
	private float calculateRate(float sum, int amount) {
		float earningRate = sum / amount * 100;
		BigDecimal bd = new BigDecimal(earningRate);
		return bd.setScale(1, RoundingMode.HALF_UP).floatValue();
	}
}
package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Judgement {
	
	public List<Rank> compareLottoNumbers(List<List<Integer>> tickets, List<Integer> winNumbers, int bonusNumber) {
		List<Rank> rank = new ArrayList<>(); 
		for (List<Integer> ticket : tickets) {
			int matchNumbers = countMatchNumbers(ticket, winNumbers);
			boolean isBonusNumber = ticket.contains(bonusNumber);
			
			rank.add(Rank.getRank(matchNumbers, isBonusNumber)); 
		}
		return rank;
	}
	
	public int countMatchNumbers(List<Integer> ticket, List<Integer> winNumbers) {
		int count = 0;
		for (int number : ticket) {
			if (winNumbers.contains(number)) {
				count++;
			}
		}
		return count;
	}
	
	public double calculateRevenue(int userMoney, List<Rank> userRank) {
		int totalRewards = 0;
		for (Rank rank : userRank) {
			totalRewards += rank.getReward();
		}
		double revenue = (double) (totalRewards - userMoney) / userMoney * 100;
		double finalRevenue = Math.round(revenue * 10) / 10.0; // 소수점 둘째자리에서 반올림
		return finalRevenue;
	}
}

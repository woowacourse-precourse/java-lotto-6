package lotto.dto;

import java.util.List;

import lotto.domain.Earning;

public class EarningDto {
	Earning earning;
	
	public EarningDto(List<Integer> array) {
		this.earning = new Earning(array);
	}
	
	public int getRankCount(int n) {
		return earning.getRankCount(n);
	}
	
	public float calculateEarningRate(int amount) {
		return earning.calculateEarningRate(amount);
	}
}
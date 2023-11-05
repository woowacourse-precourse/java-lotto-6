package model;

import java.util.List;

public class Data {

	public List<List<Integer>> lottery_list;
	public List<Integer> winning_nums;
	public int bonus;	
	public int lotto_count;

	public List<List<Integer>> getLottery_list() {
		return lottery_list;
	}

	public void setLottery_list(List<List<Integer>> lottery_list) {
		this.lottery_list = lottery_list;
	}

	public List<Integer> getWinning_nums() {
		return winning_nums;
	}

	public void setWinning_nums(List<Integer> winning_nums) {
		this.winning_nums = winning_nums;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getLotto_count() {
		return lotto_count;
	}

	public void setLotto_count(int lotto_count) {
		this.lotto_count = lotto_count;
	}
}

package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validation.WinningValidation;
import static lotto.system.Constant.FIRST_RANK;
import static lotto.system.Constant.SECOND_RANK;
import static lotto.system.Constant.THIRD_RANK;
import static lotto.system.Constant.FOURTH_RANK;
import static lotto.system.Constant.LAST_RANK;
import static lotto.system.Constant.FIRST_RANK_MATCH_COUNT;
import static lotto.system.Constant.SECOND_RANK_MATCH_COUNT;
import static lotto.system.Constant.THIRD_RANK_MATCH_COUNT;
import static lotto.system.Constant.FOURTH_RANK_MATCH_COUNT;
import static lotto.system.Constant.LAST_RANK_MATCH_COUNT;

public class Winning {
	private final List<Integer> numbers;
	private int bonus;
	
	public Winning(List<Integer> numbers) {
		winningValidation(numbers);
		this.numbers = numbers;
	}
	
	private void winningValidation(List<Integer> numbers) {
		WinningValidation.isWinningCorrect(numbers);
	}
	
	public void setBonus(int bonus) {
		bonusValidation(bonus);
		this.bonus = bonus;
	}
	
	private void bonusValidation(int bonus) {
		WinningValidation.isBonusCorrect(bonus, numbers);
	}
	
	public List<Integer> getLottoRankings(List<Lotto> lottos) {
		List<Integer> matchRanks = new ArrayList<Integer>();
		for (Lotto lotto : lottos) {
			List<Integer> lottoNumbers = lotto.getNumbers();
			int count = countContain(lottoNumbers);
			matchRanks.add(getRank(count, lottoNumbers));
		}
		List<Integer> result = countRankingFrequency(matchRanks);
		return result;
	}
	
	private int countContain(List<Integer> lottoNumbers) {
		int count= 0;
		for (int n : lottoNumbers) {
			count += isContain(n);
		}
		return count;
	}
	
	private int isContain(int n) {
		if (numbers.contains(n)) {
			return 1;
		}
		return 0;
	}
	
	private int getRank(int count, List<Integer> lottoNumbers) {
		if (count == LAST_RANK_MATCH_COUNT.getconstant())
			return LAST_RANK.getconstant();
		if (count == FOURTH_RANK_MATCH_COUNT.getconstant())
			return FOURTH_RANK.getconstant();
		if (count == THIRD_RANK_MATCH_COUNT.getconstant() && !matchBonus(lottoNumbers)) 
			return THIRD_RANK.getconstant();
		if (count == SECOND_RANK_MATCH_COUNT.getconstant() && matchBonus(lottoNumbers))
			return SECOND_RANK.getconstant();
		if (count == FIRST_RANK_MATCH_COUNT.getconstant())
			return FIRST_RANK.getconstant();
		return 0;
	}
	
	private boolean matchBonus(List<Integer> lottoNumbers) {
		if (lottoNumbers.contains(bonus)) {
			return true;
		}
		return false;
	}
	
	private List<Integer> countRankingFrequency(List<Integer> matchCounts) {
		List<Integer> frequency = new ArrayList<Integer>(); 
		for (int i = FIRST_RANK.getconstant(); i<=LAST_RANK.getconstant(); i++) {
			frequency.add(Collections.frequency(matchCounts, i));
		}
		return frequency;
	}
}
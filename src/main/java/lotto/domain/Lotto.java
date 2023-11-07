package lotto.domain;

import static lotto.domain.LottoNumber.*;
import static lotto.domain.LottoPrize.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS.getValue()) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 " + NUMBER_OF_LOTTO_NUMBERS.getValue() + "개여야 합니다.");
		}

		Set<Integer> lottoNumbers = new HashSet<>();
		for (int number : numbers) {
			if (lottoNumbers.contains(number)) {
				throw new IllegalArgumentException("[ERROR] 로또 번호 값이 중복되었습니다.");
			}
			if (number < MIN_LOTTO_NUMBER.getValue() || number > MAX_LOTTO_NUMBER.getValue()) {
				throw new IllegalArgumentException(
					"[ERROR] 로또 번호는 " + MIN_LOTTO_NUMBER.getValue() + " 이상 " + MAX_LOTTO_NUMBER.getValue()
						+ " 이하의 값이여야 합니다.");
			}
			lottoNumbers.add(number);
		}

	}

	void printNumbers() {
		System.out.println(numbers);
	}

	LottoPrize confirmWinning(Set<Integer> winningNumbers, int bonusNumber) {
		int hits = 0;
		boolean bonusHit = false;

		for (int number : numbers) {
			if (winningNumbers.contains(number)) {
				hits += 1;
			} else if (number == bonusNumber) {
				bonusHit = true;
			}
		}

		if (hits == THREE_MATCH.getMatches()) {
			return THREE_MATCH;
		} else if (hits == FOUR_MATCH.getMatches()) {
			return FOUR_MATCH;
		} else if (hits == FIVE_MATCH.getMatches()) {
			if (bonusHit) {
				return FIVE_MATCH_WITH_BONUS;
			}
			return FIVE_MATCH;
		} else if (hits == SIX_MATCH.getMatches()) {
			return SIX_MATCH;
		}
		return null;
	}
}

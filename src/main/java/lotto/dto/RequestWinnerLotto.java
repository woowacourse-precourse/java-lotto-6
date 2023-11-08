package lotto.dto;

import java.util.List;

public record RequestWinnerLotto(
	List<Integer> winnerNumbers,
	Integer bonusNumber
) {

	public static RequestWinnerLotto of(final List<Integer> winnerNumbers,
		final Integer bonusNumber) {
		return new RequestWinnerLotto(winnerNumbers, bonusNumber);
	}


}

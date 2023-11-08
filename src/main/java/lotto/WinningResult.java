package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {

	public static LottoResult calculateResult(final List<Lotto> buyLotto, final Lotto winningLotto, final int bonusNumber) {
		int total = 0;
		List<Integer> lottoResult = new ArrayList<>();

		for (final var lotto : buyLotto) {
			final Winnings winnings = checkWinnings(lotto, winningLotto, bonusNumber);
			total += winnings.getPrize();
			final var rank = winnings.getRank();
			final var count = lottoResult.get(rank);
			lottoResult.set(rank, count + 1);
		}
		return new LottoResult(lottoResult, total);
	}

	private static Winnings checkWinnings(final Lotto lotto, final Lotto winningLotto, final int bonusNumber) {
		int correctCount = collectCount(lotto.numbers(), winningLotto.numbers());
		boolean isBonusCorrect = checkBonus(lotto.numbers(), bonusNumber);

		return checkWinnings(correctCount, isBonusCorrect);
	}

	private static int collectCount(final List<Integer> lotto, final List<Integer> winningLotto) {
		int count = 0;
		for (Integer lottoNumber : lotto) {
			if (winningLotto.contains(lottoNumber)) {
				count++;
			}
		}
		return count;
	}

	private static boolean checkBonus(final List<Integer> lotto, final int bonus) {
		return lotto.contains(bonus);
	}

	private static Winnings checkWinnings(int resultCont, boolean hasBonus) {
		if (resultCont == 6)
			return Winnings.FIRST;
		if (resultCont == 5 && hasBonus)
			return Winnings.SECOND;
		if (resultCont == 5)
			return Winnings.THIRD;
		if (resultCont == 4)
			return Winnings.FOURTH;
		if (resultCont == 3)
			return Winnings.FIFTH;
		return Winnings.NOTHING;
	}
}

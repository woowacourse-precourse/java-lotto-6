package lotto.domain;

import java.util.List;

public class LottoMatcher {
    public static final String ERROR_MESSAGE_DUPLICATED_BONUS_NUMBER = "보너스 번호가 당첨번호와 중복됩니다.";

    private final Lotto winning;
    private final int bonusNumber;

    public LottoMatcher(Lotto winning, int bonusNumber) {
        this.winning = winning;

        List<Integer> winningNumbers = winning.getNumbers();
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATED_BONUS_NUMBER);
        }

        this.bonusNumber = bonusNumber;
    }

    public MatchResult match(Lotto trying) {
        List<Integer> winningNumbers = winning.getNumbers();
        List<Integer> tryingNumbers = trying.getNumbers();

        int correctNumber = 0;
        boolean correctBonusNumber = tryingNumbers.contains(bonusNumber);

        for (Integer number : tryingNumbers) {
            if (winningNumbers.contains(number)) {
                correctNumber++;
            }
        }

        return new MatchResult(correctNumber, correctBonusNumber);
    }
}

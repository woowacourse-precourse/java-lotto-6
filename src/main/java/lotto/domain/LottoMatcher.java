package lotto.domain;

import java.util.List;

public class LottoMatcher {
    public static final String ERROR_MESSAGE_DUPLICATED_BONUS_NUMBER = "보너스 번호가 당첨번호와 중복됩니다.";
    public static final String ERROR_MESSAGE_BONUS_NUMBER_OUT_OF_RANGE = "보너스 번호가 범위를 벗어났습니다.";

    private final Lotto winning;
    private final int bonusNumber;

    public LottoMatcher(Lotto winning, int bonusNumber) {
        validateBonusNumber(winning, bonusNumber);
        this.winning = winning;
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

    private void validateBonusNumber(Lotto winning, int bonusNumber) {
        var rule = LottoNumberRule.BASIC;
        if (bonusNumber < rule.getMinLottoNumber() || bonusNumber > rule.getMaxLottoNumber()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER_OUT_OF_RANGE);
        }

        List<Integer> winningNumbers = winning.getNumbers();
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATED_BONUS_NUMBER);
        }
    }
}

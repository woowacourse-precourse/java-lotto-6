package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_LENGTH_CONSTRAINT;
import static lotto.view.ErrorConstants.DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.view.ErrorConstants.DUPLICATED_WINNING_NUMBERS_ERROR_MESSAGE;
import static lotto.view.ErrorConstants.INVALID_LENGTH_ERROR_MESSAGE;

import java.util.List;

public class WinningInfo {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningInfo(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.winningNumbers = numbers.stream()
                .map(LottoNumber::create)
                .toList();
        this.bonusNumber = LottoNumber.create(bonusNumber);
    }


    public static WinningInfo create(List<Integer> numbers, int bonusNumber) {
        return new WinningInfo(numbers, bonusNumber);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (isNotValidLength(numbers)) {
            throw new IllegalArgumentException(String.format(INVALID_LENGTH_ERROR_MESSAGE.getMessage(),
                    LOTTO_LENGTH_CONSTRAINT.getValue()));
        }
        if (isWinningNumbersDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBERS_ERROR_MESSAGE.getMessage());
        }
        if (isBonusNumberDuplicated(numbers, bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isNotValidLength(List<Integer> numbers) {
        return numbers.size() != LOTTO_LENGTH_CONSTRAINT.getValue();
    }

    private boolean isWinningNumbersDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean isBonusNumberDuplicated(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public Prize getPrizeResult(Lotto lotto) {
        int numberOfMatches = getNumberOfMatches(lotto);
        boolean bonusNumberMatched = isBonusNumberMatched(lotto);
        return Prize.valueOf(numberOfMatches, bonusNumberMatched);
    }

    private int getNumberOfMatches(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    private boolean isBonusNumberMatched(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }


}

package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.constant.LottoConstant;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
        validate(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
        }

        for (int i = 1; i < numbers.size(); ++i) {
            if (Objects.equals(numbers.get(i - 1), numbers.get(i))) {
                throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_DUPLICATED);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoPrize prize(LottoWinningNumber winningNumber, LottoBonusNumber bonusNumber) {
        int numNumberMatches = calculateNumberMatches(winningNumber);
        int numBonusNumberMatches = calculateBonusNumberMatches(bonusNumber);
        return findLottoPrize(numNumberMatches, numBonusNumberMatches);
    }

    private static LottoPrize findLottoPrize(int numNumberMatches, int numBonusNumberMatches) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize.matches(numNumberMatches, numBonusNumberMatches)) {
                return lottoPrize;
            }
        }

        return LottoPrize.NONE;
    }

    private int calculateBonusNumberMatches(LottoBonusNumber bonusNumber) {
        int numBonusNumberMatches = 0;
        for (Integer number : numbers) {
            if (bonusNumber.matches(number)) {
                numBonusNumberMatches++;
            }
        }
        return numBonusNumberMatches;
    }

    private int calculateNumberMatches(LottoWinningNumber winningNumber) {
        int numNumberMatches = 0;
        for (Integer number : numbers) {
            if (winningNumber.containsNumber(number)) {
                numNumberMatches++;
            }
        }
        return numNumberMatches;
    }
}

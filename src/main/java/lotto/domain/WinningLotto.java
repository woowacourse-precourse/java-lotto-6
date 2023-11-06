package lotto.domain;

import lotto.type.Prize;

import java.util.List;
import java.util.stream.IntStream;


public class WinningLotto {
    public static final int BONUS_NUMBER_INDEX = 5;
    public static final int SECOND_MATCHING_CORRECT_NUM = 5;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public Prize matchLotto(Lotto inputLotto) {
        int winningResult = getMatchingCount(inputLotto.getNumbers());

        if(winningResult == SECOND_MATCHING_CORRECT_NUM) {
            return Prize.valueOf(winningResult, isMatchBonusNumber(inputLotto.getNumbers()));
        }
        return Prize.valueOf(winningResult, false);
    }

    private int getMatchingCount(List<Integer> inputNumbers) {
        return winningNumbers.stream()
                .filter(inputNumbers::contains)
                .toList()
                .size();
    }

    private boolean isMatchBonusNumber(List<Integer> inputLotto) {
        return inputLotto.contains(bonusNumber);
    }
}

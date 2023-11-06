package lotto.domain.lottoDraw;

import lotto.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoDraw {
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public LottoDraw(List<Integer> winningNumber) {
        validate(winningNumber);
        this.winningNumber = winningNumber.subList(0, 5);
        this.bonusNumber = winningNumber.get(6);
    }

    public static LottoDraw of(List<Integer> winningNumber) {
        return new LottoDraw(winningNumber);
    }

    private void validate(List<Integer> winningNumber) {
        if (winningNumber.size() != 7) {
            throw new IllegalArgumentException();
        }

        if (hasDuplicates(winningNumber)) {
            throw new IllegalArgumentException();
        }

        if (isNumbersOutOfRange(winningNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicates(List<Integer> winningNumber) {
        Set<Integer> numbersSet = new HashSet<>(winningNumber);
        return numbersSet.size() != winningNumber.size();
    }

    private boolean isNumbersOutOfRange(List<Integer> winningNumber) {
        return winningNumber
                .stream()
                .anyMatch(number
                        -> number < LottoConstants.MIN_NUMBER_OF_LOTTO.getValue()
                        || number > LottoConstants.MAX_NUMBER_OF_LOTTO.getValue());
    }
}

package lotto.domain;

import lotto.constants.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_NOT_NUMBER.getMessage());
        }
    }

    private List<Integer> sortList(List<Integer> numbers) {
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoRank compareLottoNumberWithFianlWinningNumber(FinalWinningNumber finalWinningNumber) {
        List<Integer> comparisonResult = Arrays.asList(0, 0);
        for(int number : numbers) {
            if(isDuplicateLottoNumberAndWinningNumber(number, finalWinningNumber.winningNumber())) {
                comparisonResult.set(0, comparisonResult.get(0) + 1);
            }
            if(isDuplicateLottoNumberAndBonusNumber(number, finalWinningNumber.bonusNumber())) {
                comparisonResult.set(1, 1);
            }
        }
        return LottoRank.getRank(comparisonResult);
    }

    private boolean isDuplicateLottoNumberAndWinningNumber(int number, WinningNumber winningNumber) {
        for(int currentWinningNumber : winningNumber.getWinningNumber()) {
            if(number == currentWinningNumber) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicateLottoNumberAndBonusNumber(int number, BonusNumber bonusNumber) {
        if(number == bonusNumber.getBonusNumber()) {
            return true;
        }
        return false;
    }
}

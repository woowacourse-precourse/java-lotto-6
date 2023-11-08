package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumber {
    private static final int WINNING_LOTTO_SIZE = 7;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final Lotto numbers;
    private final Integer bonusnumber;

    public LottoWinningNumber(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = new Lotto(numbers);

        validate(numbers, bonusNumber);

        this.bonusnumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, Integer bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicate(numbers, bonusNumber);
    }

    private void validateRange(Integer bonusNumber){
        if(!(bonusNumber>=MIN_RANGE && bonusNumber<=MAX_RANGE)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers, Integer bonusNumber){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        nonDuplicateNumbers.add(bonusNumber);

        if(nonDuplicateNumbers.size() != WINNING_LOTTO_SIZE){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}

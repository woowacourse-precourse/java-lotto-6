package lotto.model;

import java.util.List;
import lotto.util.ErrorCode;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;
    private final Integer numberLimit = 6;

    final int LOTTO_LOWER_BOUND = 1;
    final int LOTTO_UPPER_BOUND = 45;

    public WinningLotto(List<Integer> numbers, Integer bonusNum) {
        validate(numbers);
        validateWinningNumberRange(numbers);
        validateWinningNumberSize(numbers);
        validateWinningNumberUnique(numbers);
        this.winningNumbers = numbers;
        validateRedundantBonusNumber(bonusNum);
        this.bonusNumber = bonusNum;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != numberLimit) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumberSize(List<Integer> numbers) {
        if (numbers.size() != numberLimit) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumberRange(List<Integer> numbers) {
        for(int number : numbers){
            if(!(number>=LOTTO_LOWER_BOUND && number<=LOTTO_UPPER_BOUND)){
                throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateWinningNumberUnique(List<Integer> numbers) {
        List<Integer> distinctList = numbers.stream().distinct().toList();
        if (numbers.size() != distinctList.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRedundantBonusNumber(Integer bonusNumber) {
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.winningNumbers;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }



}

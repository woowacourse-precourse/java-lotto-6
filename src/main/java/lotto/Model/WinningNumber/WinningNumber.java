package lotto.Model.WinningNumber;

import static lotto.Common.ErrorMessage.*;
import static lotto.Common.LottoValue.*;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> numbers){
        validateNumberCount(numbers);
        validateNumberDuplicate(numbers);
        this.winningNumber = numbers;
    }

    public void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT_NUMBER.getValue()) {
            throw new IllegalArgumentException(WINNING_NUMBER_COUNT_INVALID.getMessage());
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().toList().size()
                != LOTTO_COUNT_NUMBER.getValue()) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE.getMessage());
        }

    }

    public List<Integer> getWinningNumber(){
        return this.winningNumber;
    }

    /**
     * 입력 검증 목록
     *
     */
}

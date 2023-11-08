package lotto.domain;

import lotto.global.ResponseStatus;
import lotto.global.constant.LottoConstant;
import lotto.global.error.ErrorMessage;
import java.util.List;

public class WinningLotto{

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private ResponseStatus validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_AVAILABLE_LENGTH.getMessage());
        }
        return ResponseStatus.OK;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}

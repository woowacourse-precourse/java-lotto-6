package lotto.domain;

import static lotto.validation.LottoValidation.validate_lottoNum;

import java.util.List;

public class WinningLotto extends Lotto{

    private final int bonusNum;

    public WinningLotto(List<Integer> numbers, int bonusNum) {
        super(numbers);
        this.bonusNum = bonusNum;
        validateWinningLottoNums(numbers, bonusNum);
    }

    private void validateWinningLottoNums(List<Integer> numbers, int bonusNum) {
        numbers.add(bonusNum);
        validate_lottoNum(numbers);
    }

}

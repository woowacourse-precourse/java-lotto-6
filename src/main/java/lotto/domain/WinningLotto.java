package lotto.domain;

import static lotto.validation.LottoValidation.validate_lottoNum;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto{

    private final int bonusNum;

    public WinningLotto(List<Integer> numbers, int bonusNum) {
        super(numbers);
        this.bonusNum = bonusNum;
        validateWinningLottoNums(numbers, bonusNum);
    }

    private void validateWinningLottoNums(List<Integer> numbers, int bonusNum) {
        List<Integer> winningNumsPlusBonus = new ArrayList<>(numbers);
        winningNumsPlusBonus.add(bonusNum);
        validate_lottoNum(winningNumsPlusBonus);
    }

}

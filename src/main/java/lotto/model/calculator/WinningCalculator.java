package lotto.model.calculator;

import java.util.List;

public class WinningCalculator {

    public int comparingLottoAndWinningNumber(List<Integer> lottoNumber, List<Integer> winningNumber) {
        return (int) lottoNumber.stream()
                .filter(winningNumber::contains)
                .count();
    }

    public int comparingBonusAndWinningNumber(List<Integer> lottoNumber, Integer bonusNumber) {
        if (lottoNumber.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }
}

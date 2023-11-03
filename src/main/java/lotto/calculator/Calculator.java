package lotto.calculator;

import static lotto.enums.AmountEnum.MIN_VALUE;

import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.WinnerLotto;
import lotto.lotto.WinningNumbers;

public class Calculator {

    public Integer convertAmountToQuantity(Integer amount){
        return amount / MIN_VALUE.getAmount();
    }

    public WinnerLotto calculateWinner(WinningNumbers winningNumbers, Lotto lotto){
        List<Integer> findWinningNumbers = winningNumbers.winningNumbers();
        List<Integer> findLottoNumbers = lotto.numbers();
        Integer winningPoint = findLottoNumbers.stream().filter(findWinningNumbers::contains).toList().size();
        return new WinnerLotto(lotto,winningPoint);
    }

}

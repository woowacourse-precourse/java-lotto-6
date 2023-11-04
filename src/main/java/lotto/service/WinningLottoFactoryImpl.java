package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

import java.util.List;

import static lotto.utils.NumberParser.toInteger;
import static lotto.utils.NumberParser.toList;

public class WinningLottoFactoryImpl implements WinningLottoFactory {
    @Override
    public Lotto winningLotto(String inputNumber){
        List<Integer> numbers = toList(inputNumber);
        return new Lotto(numbers);
    }

    @Override
    public BonusNumber bonusNumber(String inputBonusNumber) {
        int bonusNumber = toInteger(inputBonusNumber);
        return new BonusNumber(bonusNumber);
    }
}

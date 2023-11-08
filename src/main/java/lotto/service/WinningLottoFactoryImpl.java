package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

import java.util.Comparator;
import java.util.List;

import static lotto.utils.NumberParser.toInteger;
import static lotto.utils.NumberParser.toList;

public class WinningLottoFactoryImpl implements WinningLottoFactory {
    private WinningLottoFactoryImpl() {}
    private static class WinningLottoFactoryHelper {
        private final static WinningLottoFactory WINNING_LOTTO_FACTORY = new WinningLottoFactoryImpl();
    }
    public static WinningLottoFactory getInstance() {
        return WinningLottoFactoryHelper.WINNING_LOTTO_FACTORY;
    }

    @Override
    public Lotto winningLotto(String inputNumber){
        List<Integer> numbers = toList(inputNumber);
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }

    @Override
    public BonusNumber bonusNumber(String inputBonusNumber, Lotto lotto) {
        int bonusNumber = toInteger(inputBonusNumber);
        return new BonusNumber(bonusNumber, lotto);
    }
}

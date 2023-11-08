package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;

import java.util.Comparator;
import java.util.List;

import static lotto.util.NumberParser.toList;
import static lotto.util.NumberParser.toInteger;

public class WinningLottoFactoryServiceImpl implements WinningLottoFactoryService {

    private WinningLottoFactoryServiceImpl() {}
    private static class WinningLottoFactoryHelper {
        private final static WinningLottoFactoryService WINNING_LOTTO_FACTORY = new WinningLottoFactoryServiceImpl();
    }
    public static WinningLottoFactoryService getInstance() {
        return WinningLottoFactoryHelper.WINNING_LOTTO_FACTORY;
    }


    @Override
    public Lotto winningLotto(String inputNumber){
        List<Integer> numbers = toList(inputNumber);
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }

    public BonusNumber bonusNumber(String inputBonusNumber, Lotto lotto) {
        int bonusNumber = toInteger(inputBonusNumber);
        return new BonusNumber(bonusNumber, lotto);
    }
}
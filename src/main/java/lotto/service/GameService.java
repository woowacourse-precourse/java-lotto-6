package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumbersCreator;

public class GameService {
    private final NumbersCreator numbersCreator;
    private Lottos userLottos;

    public GameService(NumbersCreator numbersCreator) {
        this.numbersCreator = numbersCreator;
    }

    public void purchaseLottos(int purchaseMoney) {
        LottoMachine lottoMachine = new LottoMachine(numbersCreator);
        userLottos = lottoMachine.purchaseLotto(new Money(purchaseMoney));
    }
}

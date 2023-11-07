package lotto.service;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumbersCreator;

public class GameService {
    private final NumbersCreator numbersCreator;
    private Lottos userLottos;

    public GameService(NumbersCreator numbersCreator) {
        this.numbersCreator = numbersCreator;
    }

    public List<List<Integer>> purchaseLottos(int purchaseMoney) {
        LottoMachine lottoMachine = new LottoMachine(numbersCreator);
        userLottos = lottoMachine.purchaseLotto(new Money(purchaseMoney));

        return userLottos.getLottos().stream()
                .map(Lotto::getSortedNumbers)
                .toList();
    }
}

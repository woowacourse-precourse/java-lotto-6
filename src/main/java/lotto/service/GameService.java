package lotto.service;

import lotto.domain.*;

import java.util.List;

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

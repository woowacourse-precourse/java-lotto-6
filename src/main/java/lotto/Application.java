package lotto;

import lotto.factory.RandomNumberFactory;
import lotto.impl.LottoGame;
import lotto.impl.OneTo45LottoNumberProvider;
import lotto.type.LottoType;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumberFactory lottoNumFactory = new RandomNumberFactory(List.of(new OneTo45LottoNumberProvider()));
       // LottoGame lottoGame = new LottoGame(lottoNumFactory.find(LottoType.ONE_TO_FORTYFIVE_LOTTO_GAME), )
    }
}

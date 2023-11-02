package lotto;

import lotto.domain.Consumer;
import lotto.domain.Lotto;
import lotto.factory.RandomNumberFactory;
import lotto.impl.LottoGame;
import lotto.impl.OneTo45LottoNumberProvider;
import lotto.type.LottoType;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumberFactory lottoNumFactory = new RandomNumberFactory(List.of(new OneTo45LottoNumberProvider()));

        int purchaseLottoCount = InputView.readPurChaseLottoAmount();
        List<Integer> winningNumbers = InputView.readWinningNumber();
        int bonusNumber = InputView.readBonusNumber();

        LottoGame lottoGame = new LottoGame(lottoNumFactory.find(LottoType.ONE_TO_FORTYFIVE_LOTTO_GAME), new Lotto(winningNumbers), bonusNumber);
        Consumer consumer = new Consumer(lottoGame.purchase(purchaseLottoCount));
    }
}

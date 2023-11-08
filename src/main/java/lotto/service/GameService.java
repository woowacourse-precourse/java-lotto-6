package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchaseReceipt;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumbersCreator;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;

public class GameService {
    private final NumbersCreator numbersCreator;

    public GameService(NumbersCreator numbersCreator) {
        this.numbersCreator = numbersCreator;
    }

    public LottoPurchaseReceipt purchaseLottos(int purchaseAmount) {
        Money purchaseMoney = new Money(purchaseAmount);
        LottoMachine lottoMachine = new LottoMachine(numbersCreator);
        Lottos purchasedLottos = lottoMachine.purchaseLotto(purchaseMoney);

        return new LottoPurchaseReceipt(purchaseMoney, purchasedLottos);
    }

    public WinningStatistics getWinningStatistics(Lotto winningLotto, LottoNumber bonusNumber, Lottos userLottos) {
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        return WinningStatistics.of(winningNumbers, userLottos);
    }
}

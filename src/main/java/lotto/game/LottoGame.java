package lotto.game;

import java.util.List;
import lotto.domain.Balance;
import lotto.domain.Lotto;
import lotto.utils.Parser;
import lotto.utils.RetryExecutor;
import lotto.view.Input;
import lotto.view.Output;
import strategy.IssuanceStrategy;
import strategy.QuickpickIssuanceStrategy;

public class LottoGame {
    public void play() {
        Balance balance = RetryExecutor.execute(this::makeBalance, IllegalArgumentException.class);

        List<Lotto> lottos = purchaseLottosWithQuckpick(balance);

        Lotto winningLotto = RetryExecutor.execute(this::makeWinningLotto, IllegalArgumentException.class);
    }

    private Balance makeBalance() {
        String userInput = Input.getPurchaseAmount();
        int purchaseAmount = Parser.parsePurchaseAmount(userInput);
        return Balance.create(purchaseAmount);
    }

    private List<Lotto> purchaseLottosWithQuckpick(Balance balance) {
        IssuanceStrategy issuanceStrategy = new QuickpickIssuanceStrategy();
        LottoMachine lottoMachine = LottoMachine.create(issuanceStrategy);

        List<Lotto> lottos = lottoMachine.purchaseAll(balance);
        Output.printPurchasedLottoNumbers(lottos);

        return lottos;
    }

    private Lotto makeWinningLotto() {
        String userInput = Input.getWinningNumbers();
        List<Integer> winningNumbers = Parser.parseWinningNumbers(userInput);

        return Lotto.from(winningNumbers);
    }
}
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
        Balance balance = RetryExecutor.execute(this::createBalance, IllegalArgumentException.class);

        List<Lotto> lottos = purchaseLottosWithQuckpick(balance);
        Output.printPurchasedLottoNumbers(lottos);

    }

    private Balance createBalance() {
        String userInput = Input.getPurchaseAmount();
        int purchaseAmount = Parser.parsePurchaseAmount(userInput);
        return Balance.create(purchaseAmount);
    }

    private List<Lotto> purchaseLottosWithQuckpick(Balance balance) {
        IssuanceStrategy issuanceStrategy = new QuickpickIssuanceStrategy();
        LottoMachine lottoMachine = LottoMachine.create(issuanceStrategy);

        return lottoMachine.purchaseAll(balance);
    }
}
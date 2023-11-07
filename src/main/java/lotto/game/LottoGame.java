package lotto.game;

import lotto.domain.Balance;
import lotto.utils.Parser;
import lotto.utils.RetryExecutor;
import lotto.view.Input;

public class LottoGame {
    public void play() {
        Balance balance = RetryExecutor.execute(this::createBalance, IllegalArgumentException.class);
    }

    private Balance createBalance() {
        String userInput = Input.getPurchaseAmount();
        int purchaseAmount = Parser.parsePurchaseAmount(userInput);
        return Balance.create(purchaseAmount);
    }
}
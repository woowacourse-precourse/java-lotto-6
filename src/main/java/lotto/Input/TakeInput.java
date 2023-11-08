package lotto.Input;

import lotto.InitLotto;

public class TakeInput {
    public static InitLotto takeInput() {
        InitLotto initLotto = new InitLotto();

        initLotto.setAmount(AmountOfPurchase.takeInput());
        GenerateLottos.generateLottos(initLotto.getAmount());
        initLotto.setWinningNumbers(WinningNumbers.takeInput());
        initLotto.setBonusNumber(BonusNumber.takeInput(initLotto.getWinningNumbers()));

        return initLotto;
    }
}

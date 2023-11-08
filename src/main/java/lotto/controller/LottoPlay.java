package lotto.controller;

import lotto.view.InputView;
import lotto.domain.*;

public class LottoPlay {

    private Lotto Lotto;
    private BonusNumber BonusNumber;

    private LottoResult LottoResult;

    private LottoPurchase LottoPurchase;

    public void run() {
        userInput();
    }

    private void userInput() {
        InputView input = new InputView();
        LottoPurchase = new LottoPurchase(input.getLottoPurchase());
        Lotto = new Lotto(input.getLotto());
        BonusNumber = new BonusNumber(input.getBonusNumber());

    }
}

package lotto;

import lotto.validator.BonusNumValidator;
import lotto.validator.LottoPurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;
import lotto.validator.WinningNumsValidator;

public class Application {
    public static void main(String[] args) {
        WinningLottoValidator winningLottoValidator = new WinningLottoValidator(new WinningNumsValidator(), new BonusNumValidator());
        LottoGame lottoGame = new LottoGame(new LottoPurchaseAmountValidator(), winningLottoValidator);
        lottoGame.start();
    }
}

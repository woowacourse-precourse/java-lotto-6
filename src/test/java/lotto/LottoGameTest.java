package lotto;

import lotto.validator.BonusNumValidator;
import lotto.validator.LottoPurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;
import lotto.validator.WinningNumsValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGameTest {

    @DisplayName("입력된 로또 구입 금액과 로또 구매 장수가 일치한다.")
    @Test
    void createLottoByPurchaseAmount() {
        int purchaseAmount = 10000;
        WinningLottoValidator winningLottoValidator = new WinningLottoValidator(new WinningNumsValidator(), new BonusNumValidator());
        LottoGame lottoGame = new LottoGame(new LottoPurchaseAmountValidator(), winningLottoValidator);
        lottoGame.generateLottos(purchaseAmount);
        assertEquals(purchaseAmount / GameDetail.AMOUNT_UNIT, lottoGame.getLottos().size());
    }

}

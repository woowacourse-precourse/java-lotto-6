package lotto.domain;

import lotto.util.InputUtil;
import lotto.util.LottoGameUtil;
import lotto.util.OutputUtil;

import java.util.List;

public interface LottoGame {

    static void play() {
        int purchaseAmount = getPurchaseAmount();
        OutputUtil.println(purchaseAmount + LottoGameMessage.PURCHASE_COMPLETED_MESSAGE);
        List<Lotto> lottoNumbers = createLottoNumbers(purchaseAmount);
        Lotto winningNumber = inputLottoNumber();

    }

    static Lotto inputLottoNumber() {
        OutputUtil.println(LottoGameMessage.REQUEST_WINNING_NUMBERS);
        String winningNumber = InputUtil.EMPTY;
        try {
            winningNumber = InputUtil.readLine();
            LottoGameUtil.validNumbersContainsSeparator(winningNumber);
        } catch (IllegalArgumentException e) {
            OutputUtil.println(e.getMessage());
            inputLottoNumber();
        }
        return new Lotto(LottoGameUtil.convertLottoNumber(winningNumber));
    }
    static List<Lotto> createLottoNumbers(int purchaseAmount) {
        List<Lotto> lottoNumbers = LottoGameUtil.generateLottoNumbers(purchaseAmount);
        lottoNumbers.forEach(lotto -> lotto.viewNumberStatus());
        return lottoNumbers;
    }
    static int getPurchaseAmount() {
        OutputUtil.println(LottoGameMessage.REQUEST_PURCHASE_AMOUNT);
        String amount = InputUtil.EMPTY;
        try {
            amount = InputUtil.readLineByNumber();
            LottoGameUtil.validPurchaseAmountFormat(amount);
        } catch (IllegalArgumentException e) {
            OutputUtil.println(e.getMessage());
            getPurchaseAmount();
        }
        return LottoGameUtil.convertPurchaseAmount(amount);
    }
}

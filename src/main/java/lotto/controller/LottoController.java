package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Buyer;
import lotto.utils.Utils;
import lotto.validation.Validator;
import lotto.view.NumberSettingView;
import lotto.view.PurchaseView;

public class LottoController {
    private Buyer buyer;

    public void run() {
        initBuyer();
    }

    private void initBuyer() {
        int purchaseAmount = getPurchaseAmount();
        buyer = new Buyer(purchaseAmount);
    }

    /* 구입금액 입력 */
    private int getPurchaseAmount() {
        PurchaseView.printInputPurchaseAmount();

        try {
            int purchaseAmount = Utils.stringToInt(Console.readLine());
            Validator.checkInputPriceValidation(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }


    public void purchaseLotto() {
        //TODO: 로또 구매 내용 출력
    }

    public void getInputWinningNumbers() {
        //TODO: 당첨번호 입력
        NumberSettingView.printInputWinningNumbers();
        int[] winningNumbers = Utils.stringToIntArray(Console.readLine());
    }

    public void getInputBonusNumber() {
        //TODO: 보너스번호 입력
    }

    public void showWinningResult() {
        //TODO: 당첨 통계 출력
    }
}

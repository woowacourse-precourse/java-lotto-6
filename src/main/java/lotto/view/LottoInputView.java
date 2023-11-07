package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class LottoInputView {

    private LottoInputView() {
    }

    public static int inputPurchasePrice() {
        LottoOutputView.printPurchasePriceMessage();
        String purchasePrice = Console.readLine();
        LottoInputValidator.validateNumeric(purchasePrice);

        return Integer.parseInt(purchasePrice);
    }

}

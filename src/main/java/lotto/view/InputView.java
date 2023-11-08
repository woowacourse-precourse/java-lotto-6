package lotto.view;

import lotto.constant.InputMessage;

public class InputView {
    public void inputPurchaseAmountView() {
        System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void inputLottoNumbersView() {
        System.out.println(InputMessage.INPUT_LOTTO_NUMBERS_MESSAGE.getMessage());
    }

    public void inputBonusNumberView() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER_MESSAGE.getMessage());
    }

}

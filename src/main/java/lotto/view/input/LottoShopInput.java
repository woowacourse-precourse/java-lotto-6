package lotto.view.input;

import lotto.message.LottoBuyMessage;
import lotto.validator.InputValidator;

public class LottoShopInput extends Input{

    private final InputValidator inputValidator;

    public LottoShopInput() {
        this.inputValidator = new InputValidator();
    }

    public long requestLottoPurchaseAmount() {
        printRequestLottoPurchaseAmount();
        long amount = inputValidator.parseLong(readLine());
        inputValidator.validatePositiveNumber(amount);
        return amount;
    }

    private void printRequestLottoPurchaseAmount() {
        System.out.println(LottoBuyMessage.PURCHASE_AMOUNT_PROMPT_MESSAGE.getMassage());
        System.out.println();
    }

}

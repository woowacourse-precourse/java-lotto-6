package lotto.view.input;

import lotto.message.LottoBuyMessage;
import lotto.validator.LottoGameInputValidator;

public class LottoGameStartInput extends Input{

    private final LottoGameInputValidator validator;

    public LottoGameStartInput() {
        this.validator = new LottoGameInputValidator();
    }

    public long requestLottoPurchaseAmount() {
        printRequestLottoPurchaseAmount();
        long amount = validator.parseLong(readLine());
        validator.validatePositiveNumber(amount);
        newLine();
        return amount;
    }

    private void printRequestLottoPurchaseAmount() {
        System.out.println(LottoBuyMessage.PURCHASE_AMOUNT_PROMPT_MESSAGE.getMassage());
    }

    public void newLine() {
        System.out.println();
    }

}

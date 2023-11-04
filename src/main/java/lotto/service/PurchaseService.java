package lotto.service;

import lotto.constant.message.InputMessage;
import lotto.domain.LottoPurchase;
import lotto.util.ValidationUtil;
import lotto.view.InputView;

public class PurchaseService {
    private final InputView inputView = new InputView();
    private final ValidationUtil validationUtil =new ValidationUtil();

    public int getInputPurchase(){
        String purchase = inputView.getInputWithMessage(InputMessage.INPUT_PURCHASE.getMessage());
        LottoPurchase lottoPurchase = new LottoPurchase(validationUtil.validatePurchase(purchase));
        return lottoPurchase.getAmount();
    }
}

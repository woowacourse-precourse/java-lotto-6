package lotto.domain;

import lotto.util.InputUtil;
import lotto.util.MessageUtil;
import lotto.util.ValidateUtil;

public class LottoPlay {

    private final MessageUtil messageUtil = new MessageUtil();
    private final InputUtil inputUtil = new InputUtil();
    private final ValidateUtil validateUtil = new ValidateUtil();

    public void play(){
        messageUtil.printBonusInput();
        getUserPurchaseAmount();
    }

    private int getUserPurchaseAmount(){
        int purchaseAmount = Integer.parseInt(inputUtil.getUserInput());
        validateUtil.validatePurchase(purchaseAmount);
        return purchaseAmount;
    }

}

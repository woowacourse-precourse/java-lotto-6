package lotto.view;

import lotto.constant.message.InputMessage;
import lotto.util.InputUtil;

public class InputView {
    private final InputUtil inputUtil = new InputUtil();
//    public String getInputPurchase() {
//        return getInputWithMessage(InputMessage.INPUT_PURCHASE.getMessage());
//    }
//
//    public String getInputWinningNumber() {
//        return getInputWithMessage(InputMessage.INPUT_NUMBER.getMessage());
//    }
//
//    public String getInputBonusNumber(){
//        return getInputWithMessage(InputMessage.INPUT_BONUS.getMessage());
//    }

    public String getInputWithMessage(String message){
        System.out.println(message);
        return inputUtil.getInput();
    }
}

package lotto.view;

import lotto.constant.message.InputMessage;
import lotto.util.InputUtil;

public class InputView {
    private final InputUtil inputUtil = new InputUtil();
    public String getInputWithMessage(String message){
        System.out.println(message);
        return inputUtil.getInput();
    }
}

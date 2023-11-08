package domain;

import util.InputUtil;
import util.MessageUtil;
import util.ValidationUtil;

import java.util.List;

public class LottoBonusNumber {
    private final InputUtil inputUtil = new InputUtil();
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private int bonusNumber;
    public LottoBonusNumber getLottoBonusNumInfo() {
        messageUtil.printBonusNum();
        String bonusNum = inputUtil.userInput();
        int validBonusNumber = validationUtil.validBonusNumber(bonusNum);
        this.bonusNumber = validBonusNumber;
        return this;
    }
    public int getLottoBonusNum(){
        return bonusNumber;
    }
}

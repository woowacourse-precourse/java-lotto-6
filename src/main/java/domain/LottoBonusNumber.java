package domain;

import util.InputUtil;
import util.MessageUtil;
import util.ValidationUtil;

public class LottoBonusNumber {
    private final InputUtil inputUtil = new InputUtil();
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final MessageUtil messageUtil = new MessageUtil();

    public LottoBonusNumber getLottoBonusNumInfo() {
        messageUtil.printBonusNum();
        String bonusNumber = inputUtil.userInput();
        int validBonusNumber = validationUtil.validBonusNumber(bonusNumber);
//        System.out.println(validBonusNumber);
        return this;
    }

    }

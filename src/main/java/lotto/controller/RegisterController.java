package lotto.controller;

import static lotto.controller.DataController.convertElementStringToInteger;
import static lotto.controller.DataController.createBonus;
import static lotto.controller.DataController.createLotto;
import static lotto.controller.DataController.createRandomLotto;
import static lotto.model.SystemConstant.DataType.INTEGER;
import static lotto.model.SystemConstant.DataType.INTEGER_LIST;
import static lotto.model.SystemConstant.DataType.LONG;
import static lotto.view.SystemMessage.ASK_BONUS;
import static lotto.view.SystemMessage.ASK_MONEY;
import static lotto.view.SystemMessage.ASK_WINNING_NUMBERS;

import lotto.model.Money;
import lotto.model.Register;
import lotto.view.InputView;
import lotto.view.SystemMessage;

public class RegisterController {
    public static void storeInputData(SystemMessage systemMessage, Register register) {
        if (systemMessage == ASK_MONEY) {
            register.setMoney(new Money(Long.parseLong(InputView.inputData(LONG))));
        }
        if (systemMessage == ASK_WINNING_NUMBERS) {
            register.setFirstPrizeLotto(createLotto(convertElementStringToInteger(InputView.inputData(INTEGER_LIST)),
                    register.getBonus()));
        }
        if (systemMessage == ASK_BONUS) {
            register.setBonus(
                    createBonus(Integer.parseInt(InputView.inputData(INTEGER)), register.getFirstPrizeLotto()));
        }
    }

    public static void storeLotto(Register register) {
        long numOfTickets = register.getMoney().getAmount() / 1000;
        for (int i = 0; i < numOfTickets; i++) {
            register.addLottoTicket(createRandomLotto());
        }
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

import java.util.List;

import static lotto.message.RequestMessage.*;

public class InputView {

    public Integer requestPurchaseAmountInput(){
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE.getMessage());
        String playerInput = Console.readLine();
        return InputValidator.validatePurchaseAmount(playerInput);
    }

}

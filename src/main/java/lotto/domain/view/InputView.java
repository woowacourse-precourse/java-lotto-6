package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.model.LottoPrice;
import lotto.global.validator.Validator;

public class InputView {

    public int inputLottoPrice() {
        System.out.println(OutputType.INPUT_PURCHASE_AMOUNT_MESSAGE.getValue());
        String userInputPrice = Console.readLine();

        Validator validator = new Validator();

        if (!validator.isValidatePurchasePrice(userInputPrice)) {
            return inputLottoPrice();
        }

        return Integer.parseInt(userInputPrice);
    }



}

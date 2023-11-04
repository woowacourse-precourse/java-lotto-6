package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.OutputView.INPUT_PURCHASE_PRICE;
import static lotto.domain.UserInputValidation.isValidPurchaseAmount;

public class UserInput {

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_PRICE.getMessage());

        return isValidPurchaseAmount(readLine());
    }

}

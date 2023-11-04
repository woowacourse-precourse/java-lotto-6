package lotto.domain;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.domain.UserInputValidation.isValidWinningNumber;
import static lotto.view.OutputView.INPUT_PURCHASE_PRICE;
import static lotto.domain.UserInputValidation.isValidPurchaseAmount;
import static lotto.view.OutputView.INPUT_WINNING_NUMBER;

public class UserInput {

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_PRICE.getMessage());

        return isValidPurchaseAmount(readLine());
    }

    public ArrayList<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER.getMessage());

        return isValidWinningNumber(readLine());
    }

}

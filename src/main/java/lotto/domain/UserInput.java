package lotto.domain;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.domain.UserInputValidation.*;
import static lotto.view.OutputView.*;

public class UserInput {

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_PRICE.getMessage());

        return isValidPurchaseAmount(readLine());
    }

    public ArrayList<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER.getMessage());

        return isValidWinningNumber(readLine());
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());

        return isValidBonusNumber(readLine());
    }

}

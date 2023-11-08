package lotto.domain;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.domain.UserInputValidation.*;
import static lotto.view.OutputView.*;

public class UserInput {

    public static int inputPurchaseAmount() {
        try {
            System.out.println(INPUT_PURCHASE_PRICE.getMessage());

            return isValidPurchaseAmount(readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return inputPurchaseAmount();
        }
    }

    public static ArrayList<Integer> inputWinningNumber() {
        try {
            System.out.println(INPUT_WINNING_NUMBER.getMessage());

            return isValidWinningNumber(readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return inputWinningNumber();
        }
    }

    public static int inputBonusNumber(ArrayList<Integer> winningNumbers) {
        try {
            System.out.println(INPUT_BONUS_NUMBER.getMessage());

            return isValidBonusNumber(readLine() , winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return inputBonusNumber(winningNumbers);
        }
    }

}

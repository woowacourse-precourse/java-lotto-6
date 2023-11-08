package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.MessageDisplay;
import static lotto.controller.UserInputValidator.isValidBuyingPrice;
import static lotto.controller.UserInputValidator.isValidWinNumbers;
import static lotto.controller.UserInputValidator.isValidBonusNumbers;

import java.util.ArrayList;
import java.util.List;

public class UserInputController {

    /* 유저가 유효한 값을 입력할 때까지 구매 금액을 입력받는다. */
    public static int getLottoBuyingPrice() {
        boolean exceptionThrown = true;
        int buyingPrice = 0;
        while (exceptionThrown) {
            String userInput = Console.readLine();
            try {
                buyingPrice = isValidBuyingPrice(userInput);
                exceptionThrown = false;
            } catch (IllegalArgumentException e) {
                System.out.println("[Error]" + e.getMessage());
            }
        }
        return buyingPrice;
    }
    public static List<Integer> getWinNumbers() {
        boolean exceptionThrown = true;
        List<Integer> winNumbers = new ArrayList<>();
        while (exceptionThrown) {
            String userInput = Console.readLine();
            try {
                winNumbers = isValidWinNumbers(userInput);
                exceptionThrown = false;
            } catch (IllegalArgumentException e) {
                System.out.print("[Error]" + e.getMessage());
            }
        }
        return winNumbers;
    }
    public static int getBonusNumbers() {
        int bonusNumber = 0;
        boolean exceptionThrown = true;
        while (exceptionThrown) {
            String userInput = Console.readLine();
            try {
                bonusNumber = isValidBonusNumbers(userInput);
                exceptionThrown = false;
            } catch (IllegalArgumentException e) {
                System.out.print("[Error]" + e.getMessage());
            }
        }
        return bonusNumber;
    }
}

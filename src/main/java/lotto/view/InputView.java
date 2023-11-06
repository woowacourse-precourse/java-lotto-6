package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PrintMessage;
import lotto.utils.InputException;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        String purchaseAmount = "";

        while (true) {
            try {
                purchaseAmount = printAndInput(PrintMessage.INPUT_PURCHASE_AMOUNT);
                InputException.validatePurchaseAmount(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> inputWinningNumber() {
        List<Integer> winningNumberList = new ArrayList<>();
        while (true) {
            try {
                String winningNumber = printAndInput(PrintMessage.INPUT_WINNING_NUMBER);
                winningNumberList = InputException.validateWinningNumber(winningNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumberList;
    }

    public static int inputBonusNumber(List<Integer> list) {
        String bonusNumber = "";
        while (true) {
            try {
                bonusNumber = printAndInput(PrintMessage.INPUT_BONUS_NUMBER);
                InputException.validateBonusNumber(bonusNumber, list);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(bonusNumber);
    }

    public static String printAndInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}

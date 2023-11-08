package lotto;

import lotto.domain.Validator;
import lotto.view.ConsoleView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        ConsoleView.printInputPurchaseAmountMessage();
        inputPurchaseAmount();
    }

    private static int inputPurchaseAmount() {
        while(true) {
            try {
                String purchaseAmount = readLine();
                Validator.validPurchaseAmount(purchaseAmount);
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

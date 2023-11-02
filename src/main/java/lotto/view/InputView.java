package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public class InputView {

    private InputView() {
    }

    public static String inputPurchasePrice() {
        String purchasePrice = Console.readLine();
        InputValidator.validatePurchasePrice(purchasePrice);
        return purchasePrice;
    }
}

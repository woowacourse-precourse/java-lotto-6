package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.global.ErrorCode;
import lotto.view.exception.InputException;

public class InputView {

    private static InputView inputView = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public int inputPurchaseAmount(){
        String userInput = readLine();
        validatePurchaseAmount(userInput);
        int purchaseAmount = Integer.parseInt(userInput);
        return purchaseAmount;
    }

    private void validatePurchaseAmount(String userInput) {
        try {
            int purchaseAmount = Integer.parseInt(userInput);
            if(purchaseAmount % 1000 != 0){
                throw new InputException(ErrorCode.INVALID_INPUT_PURCHASE_AMOUNT);
            }
        } catch (NumberFormatException e) {
            throw new InputException(ErrorCode.INVALID_INPUT_PURCHASE_AMOUNT);
        }
    }

}

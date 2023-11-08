package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.global.ErrorCode;
import lotto.global.util.StringConverter.StringToIntegerListConverter;
import lotto.view.exception.InputException;

public class InputView {
    StringToIntegerListConverter stringToIntegerListConverter = StringToIntegerListConverter.getInstance();
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

    public List<Integer> inputWinningNumbers(){
        String userInput = readLine();
        List<Integer> userInputNumbers;
        try {
            userInputNumbers = stringToIntegerListConverter.convert(userInput);
        } catch (NumberFormatException e) {
            throw new InputException(ErrorCode.INVALID_INPUT_LOTTO_NUMBERS);
        }
        return userInputNumbers;
    }

    public int inputBonusNumber(){
        String userInput = readLine();
        validateInputIsNumber(userInput);
        return Integer.parseInt(userInput);
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

    private void validateInputIsNumber(String userInput){
        try{
            Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new InputException(ErrorCode.INVALID_INPUT_LOTTO_NUMBERS);
        }
    }

}

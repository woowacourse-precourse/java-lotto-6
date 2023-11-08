package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static lotto.view.ErrorMessage.*;
import static lotto.Validator.*;

public class InputView {

    public static final String purchaseAmountMessage = "구입 금액을 입력해 주세요.";
    public static final String WinningNumbersMessage = "당첨 번호를 입력해 주세요.";
    public static final String BonusNumberMessage = "보너스 번호를 입력해 주세요.";

    private static final String INPUT_REGEXP = "^[1-9]\\d*(,[1-9]\\d*)*$";

    public int inputPurchaseAmount(){
        System.out.println(purchaseAmountMessage);
        String input = Console.readLine();
        System.out.println();

        validateNotEmptyInput(input);
        int amount = validateInputIsNumeric(input);

        return amount;
    }

    public List<Integer> inputWinningNumber(){
        System.out.println(WinningNumbersMessage);
        String input = Console.readLine();
        System.out.println();
        validateNotEmptyInput(input);

        List<Integer> numbers = validateCanSplittedInput(input);
        validateNumberLength(numbers);
        validateComposedOfUniqueNumbers(numbers);
        for(Integer number : numbers){
            validatePositiveNumber(number);
            validateNumberInRange(number);
        }

        return numbers;
    }

    public int inputBonusNumber(){
        System.out.println(BonusNumberMessage);
        String input = Console.readLine();
        System.out.println();
        validateNotEmptyInput(input);
        int bonusNumber = validateInputIsNumeric(input);
        validatePositiveNumber(bonusNumber);
        validateNumberInRange(bonusNumber);

        return bonusNumber;
    }


    private static List<Integer> validateCanSplittedInput(String input){
        if(!input.matches(INPUT_REGEXP)) throw new IllegalArgumentException(NOT_VALID_LENGTH);
        return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    }


}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;
import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.ErrorMessage.*;
import static lotto.Validator.*;

public class InputView {

    public static final String purchaseAmountMessage = "구입 금액을 입력해 주세요.";
    public static final String WinningNumbersMessage = "당첨 번호를 입력해 주세요.";
    public static final String BonusNumberMessage = "보너스 번호를 입력해 주세요.";

    private static final String DELIMITER = ",";
    private static final String WHITE_SPACE = " ";

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

        return numbers;
    }

    public int inputBonusNumber(){
        System.out.println(BonusNumberMessage);
        String input = Console.readLine();
        System.out.println();
        validateNotEmptyInput(input);
        int bonusNumber = validateInputIsNumeric(input);
        validatePositiveNumber(bonusNumber);
        return bonusNumber;
    }


    private static List<Integer> validateCanSplittedInput(String input){
        validateNotBeDividedUsingDelimiter(input);
        validateDelimiterInAppropriatePlace(input);
        validateHasRepeatedDelimiter(input);
        return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    }

    private static void validateHasRepeatedDelimiter(String input) {
        if(input.contains(DELIMITER.repeat(2))) throw new IllegalArgumentException(HAS_REPEATED_DELIMITER);
    }

    private static void validateDelimiterInAppropriatePlace(String input) {
        checkStartOrEndDelimiter(input);
        checkPlaceBetweenMargins(input);
    }

    private static void checkPlaceBetweenMargins(String input) {
        if(input.contains(WHITE_SPACE + DELIMITER) || input.contains(DELIMITER + WHITE_SPACE)) {
            throw new IllegalArgumentException(PLACE_BETWEEN_MARGINS);
        }
    }

    private static void checkStartOrEndDelimiter(String input) {
        if(input.startsWith(DELIMITER) || input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(START_OR_END_WITH_DELIMITER);
        }
    }

    private static void validateNotBeDividedUsingDelimiter(String input){
        if(input.split(DELIMITER).length != 6) throw new IllegalArgumentException(NOT_VALID_LENGTH);
    }
}

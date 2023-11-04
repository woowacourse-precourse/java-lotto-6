package lotto.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.Error.*;
import static lotto.view.Message.*;
import static lotto.view.Standard.*;

public class InputView {
    public static int enterPurchaseAmounts() {
        System.out.println(ENTER_PURCHASE_AMOUNT.getMessage());

        return parsingPurchaseAmounts(readLine());
    }

    private static int parsingPurchaseAmounts(String userInput) {
        validatePurchaseAmounts(userInput);

        return Integer.parseInt(userInput);
    }

    private static void validatePurchaseAmounts(String userInput) {
        if (!userInput.matches(STANDARD_NUMBER.getStandard())) {
            throw new IllegalArgumentException(VALIDATE_PURCHASE_AMOUNTS.getError());
        }
    }

    public static List<Integer> enterLottoNumbers() {
        System.out.println();
        System.out.println(ENTER_LOTTO_NUMBERS.getMessage());

        String userInput = readLine();

        return Arrays.stream(userInput.split(STANDARD_OF_SPLIT.getStandard()))
                .map(InputView::parsingLottoNumbers)
                .toList();
    }

    private static int parsingLottoNumbers(String userInput) {
        validateLottoNumbers(userInput);

        return Integer.parseInt(userInput);
    }

    private static void validateLottoNumbers(String userInput) {
        if (!userInput.matches(STANDARD_NUMBER.getStandard())) {
            throw new IllegalArgumentException(VALIDATE_LOTTO_NUMBERS.getError());
        }
    }

    public static int enterBonusNumber() {
        System.out.println();
        System.out.println(ENTER_BONUS_NUMBERS.getMessage());

        String userInput = readLine();

        return parsingBonusNumber(userInput);
    }

    private static int parsingBonusNumber(String userInput) {
        validateBonusNumber(userInput);

        return Integer.parseInt(userInput);
    }

    private static void validateBonusNumber(String userInput) {
        if (!userInput.matches(STANDARD_NUMBER.getStandard())) {
            throw new IllegalArgumentException(VALIDATE_BONUS_NUMBER.getError());
        }
    }
}

package lotto.service.validator;

import java.util.ArrayList;
import java.util.List;

import static lotto.service.validator.ServiceValidateRegistry.*;

public class LottoValidator {
    public static void lottoTicketValidate(final List<Integer> userInput) {
        checkDuplicateNumbers(userInput);
        checkRangeOfNumbers(userInput);
        checkSizeOfNumbers(userInput);
    }

    public static void winningNumberValidate(final List<Integer> userInput) {
        checkDuplicateNumbers(userInput);
        checkRangeOfNumbers(userInput);
        checkSizeOfNumbers(userInput);
    }

    public static void bonusNumberValidate(final int userInput) {
        List<Integer> userInputList = new ArrayList<>();
        userInputList.add(userInput);
        checkRangeOfNumbers(userInputList);
    }
}

package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExceptionHandler {

    private static final int ZERO = 0;
    private static final int SINGLE_LOTTO_TICKET_PRICE = 1000;
    private static final String NULL = "";
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    private ExceptionMessage exceptionMessage;

    public void checkNotNull(String input) {
        if(input.equals(NULL) || input.isEmpty())
            exceptionMessage.NULL_INPUT.throwException();
    }

    public void checkInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                exceptionMessage.INVALID_NUMBER.throwException();
            }
        }
    }

    public void checkDuplicates(List<String> inputs) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String input : inputs) {
            if (uniqueNumbers.contains(input)) {
                exceptionMessage.LOTTO_NUMBER_DUPLICATES.throwException();
            }
        }
    }

    public void checkNonNegativeAmount(int input) {
        if(input < ZERO)
            exceptionMessage.INPUT_NEGATIVE_AMOUNT.throwException();
    }

    public void checkMultipleOfThousand(int input) {
        if(!(input % SINGLE_LOTTO_TICKET_PRICE == ZERO)) {
            exceptionMessage.NOT_MULTIPLE_OF_THOUSAND.throwException();
        }
    }

    public void checkInRange(int input) {
        if (input < START_LOTTO_NUMBER || END_LOTTO_NUMBER < input) {
            exceptionMessage.OUT_OF_RANGE.throwException();
        }
    }

    public void checkForDuplicateLottoNumbersAndBonus(int bonusNumber, List<Integer> winningNumbers) {
        for(int winningNumber : winningNumbers){
            if (winningNumber == bonusNumber) {
                exceptionMessage.BONUS_NUMBER_DUPLICATES.throwException();
            }
        }
    }
}
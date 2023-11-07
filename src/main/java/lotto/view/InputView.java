package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lotto.constant.Message;
import lotto.exception.ErrorMessagePrinter;
import lotto.exception.LottoExceptionMessage;

public class InputView {
    private static final String SPLIT_DELIMITER = ",";

    public int inputPrice() {
        Integer validPrice = null;

        while (isNotValid(validPrice)) {
            printNewLine();
            System.out.println(Message.INPUT_PRICE.getMessage());
            String inputPrice = Console.readLine().trim();
            validPrice = parseValidPrice(inputPrice);
        }
        return validPrice;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> validWinningNumbers = null;

        while (isNotValid(validWinningNumbers)) {
            printNewLine();
            System.out.println(Message.INPUT_WINNING_NUMBERS.getMessage());
            String inputWinningNumbers = Console.readLine();
            validWinningNumbers = parseValidWinningNumbers(inputWinningNumbers);
        }

        return validWinningNumbers;
    }

    public int inputBonusNumber() {
        Integer validBonusNumber = null;

        while (isNotValid(validBonusNumber)) {
            printNewLine();
            System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
            String inputBonusNumber = Console.readLine().trim();

            validBonusNumber = parseValidBonusNumber(inputBonusNumber);

        }
        return validBonusNumber;
    }

    private boolean isNotValid(Object object) {
        return Objects.isNull(object);
    }

    private Integer parseValidPrice(String inputPrice) {
        try {
            if (isPriceNumber(inputPrice)) {
                return Integer.parseInt(inputPrice);
            }
        } catch (IllegalArgumentException e) {
            ErrorMessagePrinter.printError(e);
        }
        return null;
    }

    private boolean isPriceNumber(String inputPrice) {
        try {
            Integer.parseInt(inputPrice);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASE_PRICE_MUST_BE_NUMBER.getMessage());
        }
    }

    private List<Integer> parseValidWinningNumbers(String inputWinningNumbers) {
        try {
            if (isWinningNumbers(inputWinningNumbers)) {
                return inputWinningNumbersToList(inputWinningNumbers);
            }

        } catch (IllegalArgumentException e) {
            ErrorMessagePrinter.printError(e);
        }
        return null;
    }

    private boolean isWinningNumbers(String inputWinningNumbers) {
        try {
            inputWinningNumbersToList(inputWinningNumbers);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.WINNING_NUMBERS_MUST_BE_NUMBERS.getMessage());
        }

    }

    private List<Integer> inputWinningNumbersToList(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(SPLIT_DELIMITER, -1))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private Integer parseValidBonusNumber(String inputBonusNumber) {
        try {
            if (isBonusNumber(inputBonusNumber)) {
                return Integer.parseInt(inputBonusNumber);
            }
        } catch (IllegalArgumentException e) {
            ErrorMessagePrinter.printError(e);
        }
        return null;
    }

    private boolean isBonusNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.BONUS_NUMBER_MUST_BE_NUMBER.getMessage());
        }
    }

    private void printNewLine() {
        System.out.println();
    }
}

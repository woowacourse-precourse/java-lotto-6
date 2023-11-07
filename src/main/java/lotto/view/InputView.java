package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lotto.constant.Message;
import lotto.exception.ErrorPrinter;
import lotto.exception.LottoExceptionMessage;

public class InputView {
    public int inputPrice() {
        Integer validPrice = null;

        while (!isValidInteger(validPrice)) {
            printNewLine();
            System.out.println(Message.INPUT_PRICE.getMessage());
            String inputPrice = Console.readLine().trim();
            validPrice = parseValidPrice(inputPrice);
        }
        return validPrice;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> validWinningNumbers = null;

        while (!isValidWinningNumbers(validWinningNumbers)) {
            printNewLine();
            System.out.println(Message.INPUT_WINNING_NUMBERS.getMessage());
            String inputWinningNumbers = Console.readLine();
            validWinningNumbers = parseValidWinningNumbers(inputWinningNumbers);
        }

        return validWinningNumbers;
    }

    public int inputBonusNumber() {
        Integer validBonusNumber = null;

        while (!isValidInteger(validBonusNumber)) {
            printNewLine();
            System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
            String inputBonusNumber = Console.readLine().trim();

            validBonusNumber = parseValidBonusNumber(inputBonusNumber);

        }
        return validBonusNumber;
    }

    private boolean isValidInteger(Integer validInteger) {
        return Objects.nonNull(validInteger);
    }

    private Integer parseValidPrice(String inputPrice) {
        try {
            if (isNumber(inputPrice)) {
                return Integer.parseInt(inputPrice);
            }
        } catch (IllegalArgumentException e) {
            ErrorPrinter.printError(e);
        }
        return null;
    }

    private boolean isNumber(String inputPrice) {
        try {
            Integer.parseInt(inputPrice);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASE_PRICE_MUST_BE_NUMBER.getMessage());
        }
    }

    private boolean isValidWinningNumbers(List<Integer> validWinningNumbers) {
        return Objects.nonNull(validWinningNumbers);
    }


    private List<Integer> parseValidWinningNumbers(String inputWinningNumbers) {
        try {
            return parseWinningNumbers(inputWinningNumbers);
        } catch (IllegalArgumentException e) {
            ErrorPrinter.printError(e);
            return null;
        }
    }

    private List<Integer> parseWinningNumbers(String inputWinningNumbers) {
        try {
            return Arrays.stream(inputWinningNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.WINNING_NUMBERS_MUST_BE_NUMBERS.getMessage());
        }

    }

    private Integer parseValidBonusNumber(String inputBonusNumber) {
        try {
            if (isBonusNumber(inputBonusNumber)) {
                return Integer.parseInt(inputBonusNumber);
            }
        } catch (IllegalArgumentException e) {
            ErrorPrinter.printError(e);
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

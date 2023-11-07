package lotto;

import static java.util.stream.Collectors.toList;
import static lotto.resource.TextResourceProvider.BONUS_NUMBER_CANNOT_CONVERT_TO_INTEGER_TEXT;
import static lotto.resource.TextResourceProvider.ERROR_TEXT_FORMAT;
import static lotto.resource.TextResourceProvider.INPUT_BONUS_NUMBER_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_DELIMITER;
import static lotto.resource.TextResourceProvider.INPUT_PURCHASE_AMOUNT_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_WINNING_NUMBERS_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT;

import java.util.Arrays;
import java.util.List;
import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidPurchasedAmountException;
import lotto.exception.InvalidWinningNumbersException;

public class InputInterface {

    private Input in;
    private Output out;

    private InputConverter converter;

    public InputInterface(Input input, Output output, InputConverter converter) {
        this.in = input;
        this.out = output;
        this.converter = converter;
    }

    public long getPurchasedAmount() {
        out.println(INPUT_PURCHASE_AMOUNT_TEXT);
        return getValidPurchasedAmount();
    }

    public List<Integer> getWinningNumbers() {
        out.println(INPUT_WINNING_NUMBERS_TEXT);
        return getValidWinningNumbers();
    }

    public int getBonusNumber(List<Integer> numbers) {
        out.println(INPUT_BONUS_NUMBER_TEXT);
        return getValidBonusNumber(numbers);
    }

    private long getValidPurchasedAmount() {
        try {
            String input = in.readLine();
            long purchaseAmount = converter.convertToPurchasedAmount(input);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            out.println(ERROR_TEXT_FORMAT.format(e.getMessage()));
            return getPurchasedAmount();
        }
    }

    private List<Integer> getValidWinningNumbers() {
        try {
            String input = in.readLine();
            return converter.convertToWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            out.println(ERROR_TEXT_FORMAT.format(e.getMessage()));
            return getValidWinningNumbers();
        }
    }

    private int getValidBonusNumber(List<Integer> numbers) {
        try {
            String input = in.readLine();
            return converter.convertToBonusNumber(input, numbers);
        } catch (IllegalArgumentException e) {
            out.println(ERROR_TEXT_FORMAT.format(e.getMessage()));
            return getValidBonusNumber(numbers);
        }
    }
}

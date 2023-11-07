package lotto.util;

import static lotto.constant.ExceptionMessages.PURCHASE_AMOUNT_FORMAT_EXCEPTION_MESSAGE;
import static lotto.constant.ExceptionMessages.WINNING_NUMBER_FORMAT_EXCEPTION_MESSAGE;

import java.util.Arrays;
import java.util.List;
import lotto.domain.WinningNumber;

public class StringParser {
    String DELIMITER = ",";

    public Integer parsePurchaseAmount(String str) {
        try {
            int parsed = Integer.parseInt(str);
            Validator.validatePositiveInteger(parsed);
            return parsed;
        } catch (Exception e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_FORMAT_EXCEPTION_MESSAGE.toString());
        }
    }

    public WinningNumber parseWinningNumber(String str) {
        try {
            List<Integer> parsed = Arrays.asList(str.split(DELIMITER)).stream()
                    .map(Integer::parseInt)
                    .toList();
            Validator.validatePositiveIntegerList(parsed);
            return new WinningNumber(parsed);
        } catch (Exception e) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_EXCEPTION_MESSAGE.toString());
        }
    }
}

package lotto.view;

import java.util.List;
import lotto.dto.PurchaseAmountRequest;
import lotto.dto.WinningNumbersRequest;
import lotto.validator.InputValidator;

public class InputMapper {

    private static final String WINNING_NUMBER_DELIMITER = ",";

    public PurchaseAmountRequest inputToPurchaseAmountRequest(String input) {
        InputValidator.validateIsInteger(input);
        return new PurchaseAmountRequest(Integer.valueOf(input));
    }

    public WinningNumbersRequest inputToWinningNumbersRequest(String input) {
        InputValidator.validateCommaSeparatedIntegers(input);
        return new WinningNumbersRequest(
            List.of(input.split(WINNING_NUMBER_DELIMITER))
                .stream()
                .map(Integer::valueOf)
                .toList()
        );
    }
}

package lotto.view;

import java.util.List;
import lotto.dto.BonusNumberRequest;
import lotto.dto.PurchaseAmountRequest;
import lotto.dto.WinningNumberRequest;
import lotto.validator.InputValidator;

public class InputMapper {

    private static final String WINNING_NUMBER_DELIMITER = ",";

    public PurchaseAmountRequest inputToPurchaseAmountRequest(String input) {
        InputValidator.validateIsInteger(input);
        return new PurchaseAmountRequest(Integer.valueOf(input));
    }

    public WinningNumberRequest inputToWinningNumberRequest(String input) {
        InputValidator.validateCommaSeparatedIntegers(input);
        return new WinningNumberRequest(
            List.of(input.split(WINNING_NUMBER_DELIMITER))
                .stream()
                .map(Integer::valueOf)
                .toList()
        );
    }

    public BonusNumberRequest inputToBonusNumberRequest(String input) {
        InputValidator.validateIsInteger(input);
        return new BonusNumberRequest(Integer.valueOf(input));
    }
}

package lotto.input;

import java.util.ArrayList;
import java.util.List;
import lotto.util.StringUtil;

public class InputProcessor {
    private final InputValidator inputValidator = new InputValidator();

    public Integer processPurchaseAmount(String input) {
        Integer purchaseAmount = StringUtil.convertToInteger(input);

        inputValidator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> processWinningNumbers(String input) {
        List<Integer> winningNumbers = new ArrayList<>();

        List<String> tokenizedInputs = StringUtil.tokenizeWithDelimiter(input, ",");
        for (String tokenizedInput : tokenizedInputs) {
            winningNumbers.add(StringUtil.convertToInteger(tokenizedInput));
         }

        inputValidator.validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }
}

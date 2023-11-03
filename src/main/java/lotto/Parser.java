package lotto;

import lotto.Validator.Validator;

public class Parser {
    public static int parsePurchaseAmount(String input) {
        int purchaseAmount = Validator.validateParseInt(input);
        return purchaseAmount;
    }
}

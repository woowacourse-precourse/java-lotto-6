package lotto.validate;

import java.util.regex.Pattern;

public class PurchaseAmountValidation implements LottoValidation {
    @Override
    public boolean validate(final String userInput) {
        if (!Pattern.matches("^[1-9]\\d*$", userInput)) return false;
        int purchaseAmount = Integer.parseInt(userInput);
        return purchaseAmount % 1000 == 0;
    }
}

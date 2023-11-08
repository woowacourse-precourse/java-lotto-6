package lotto.Validator;

import java.util.List;

public class ValidatorFactory {
    public static Validator<String> forInputAmount() {
        return new PurchaseAmountValidator();
    }

    public static Validator<List<String>> forInputWinningNumber() {
        return new WinningNumberValidator();
    }

    public static Validator<String> forInputBonusNumber() {
        return new BonusNumberValidator();
    }
}

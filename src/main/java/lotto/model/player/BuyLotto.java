package lotto.model.player;

import lotto.constant.ErrorMessage;
import lotto.constant.UnitNumber;

public class BuyLotto {
    private static int purchaseAmount;

    public BuyLotto(String amount) {
        validate(amount);
        purchaseAmount = Integer.parseInt(amount);
    }

    public static void validate(String amount) {
        validateIsNumber(amount);
        validateIsDivisibleBy1000(amount);
        validateIsPositiveInteger(amount);
    }

    private static void validateIsNumber(String amount) {
        try {
            Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NAN.getMessage());
        }
    }

    private static void validateIsDivisibleBy1000(String amount) {
        if((Double.parseDouble(amount) % UnitNumber.LOTTO_PRICE.getNumber()) != UnitNumber.ZERO.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_BY_1000.getMessage());
        }
    }

    private static void validateIsPositiveInteger(String amount) {
        if(Double.parseDouble(amount) <= UnitNumber.ZERO.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.MIN.getMessage());
        }
    }

    public Integer getLottoPurchase() {
        return purchaseAmount;
    }
}
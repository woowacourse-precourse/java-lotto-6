package lotto.io;

import lotto.domain.PurchaseAmount;

public class InputMapper {

    public PurchaseAmount toPurchaseAmount(final String input) {
        return new PurchaseAmount(Integer.parseInt(input));
    }
}

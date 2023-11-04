package lotto.io;

import lotto.domain.Amount;

public class InputMapper {

    public Amount toAmount(final String input) {
        return new Amount(Integer.parseInt(input));
    }
}

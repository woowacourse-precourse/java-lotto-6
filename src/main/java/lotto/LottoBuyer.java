package lotto;

import lotto.io.ConsoleManager;

public class LottoBuyer {

    private static final int PRICE_UNIT = 1_000;

    private final ConsoleManager consoleManager;

    public LottoBuyer(ConsoleManager consoleManager) {
        this.consoleManager = consoleManager;
    }

    protected long payLotto() {
        return consoleManager.inputPurchasePrice()
                .getValue();
    }

    protected long getLottoCount(final long price) {
        return price / PRICE_UNIT;
    }

}

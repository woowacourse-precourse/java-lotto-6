package lotto;

import java.util.stream.IntStream;
import lotto.io.ConsoleManager;

public class LottoBuyer {

    private static final int PRICE_UNIT = 1_000;

    private final ConsoleManager consoleManager;

    public LottoBuyer(ConsoleManager consoleManager) {
        this.consoleManager = consoleManager;
    }

    protected int payLotto() {
        return consoleManager.inputPurchasePrice()
                .getValue();
    }

    protected int getLottoCount(final int price) {
        return price / PRICE_UNIT;
    }

}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.LongStream;
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

}

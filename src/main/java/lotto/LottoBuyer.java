package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
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

    protected List<Lotto> purchaseLottos(final int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> purchaseOneLotto())
                .toList();
    }

    private Lotto purchaseOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Lotto.getLottoLowerBound(),
                Lotto.getLottoUpperBound(),
                Lotto.getLottoNumberCount());

        return new Lotto(numbers);
    }

}

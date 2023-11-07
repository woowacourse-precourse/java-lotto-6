package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public abstract class ResultView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public abstract void println(final String text);

    public void printException(final Exception exception) {
        println(ERROR_PREFIX + exception.getMessage());
    }

    public void displayPurchasedLottos(final List<Lotto> purchasedLottos) {
        println(String.format("%n%d개를 구매했습니다.", purchasedLottos.size()));
        purchasedLottos.stream()
                .map(Lotto::formatNumbers)
                .forEach(this::println);
    }
}

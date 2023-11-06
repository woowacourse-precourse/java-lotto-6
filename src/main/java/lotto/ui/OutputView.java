package lotto.ui;

import static java.util.stream.Collectors.joining;

import lotto.state.PurchasedLottoState;

public final class OutputView extends ConsoleWriter {
    public void print(PurchasedLottoState purchasedLottoState) {
        this.newLine();
        this.printf("%d개를 구매했습니다.\n", purchasedLottoState.quantity());
        this.println(purchasedLottoState.value()
                .stream().map(lotto -> lotto.stream().sorted()
                        .map(String::valueOf)
                        .collect(joining(",", "[", "]")))
                .collect(joining("\n")));
    }
}

package lotto.ui;

import static java.util.stream.Collectors.joining;

import lotto.state.PurchasedLottoState;
import lotto.state.WinningStatisticsState;

public final class OutputView extends ConsoleWriter {
    public void print(PurchasedLottoState purchasedLottoState) {
        this.newLine();
        this.printf("%d개를 구매했습니다.\n", purchasedLottoState.quantity());
        this.println(purchasedLottoState.value()
                .stream()
                .map(lotto -> lotto.stream()
                        .sorted()
                        .map(String::valueOf)
                        .collect(joining(", ", "[", "]")))
                .collect(joining("\n")));
    }

    public void print(WinningStatisticsState winningStatisticsState) {
        this.newLine();
        this.printf("""
                당첨 통계
                ---
                %s
                """, winningStatisticsState.toResult());
        this.newLine();
        this.printf("총 수익률은 %s입니다.", winningStatisticsState.getProfitResult());
    }

    public void printError(String message) {
        this.printf("[ERROR] %s", message);
        this.newLine();
    }
}

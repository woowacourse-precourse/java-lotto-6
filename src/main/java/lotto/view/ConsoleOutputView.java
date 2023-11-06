package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoResponse;

public class ConsoleOutputView implements OutputView {

    private static final int ONE_HUNDRED = 100;

    @Override
    public void printMoneyRequestMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void printPurchasedLottos(final List<LottoResponse> lottos) {
        printNewLine();
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.forEach(lottoResponse -> {
            List<Integer> lotto = new ArrayList<>(lottoResponse.getLotto());
            Collections.sort(lotto);
            System.out.println(lotto);
        });
    }

    @Override
    public void printWinningNumberRequestMessage() {
        printNewLine();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void printBonusNumberRequestMessage() {
        printNewLine();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void printWinningStatistics(final Map<String, Long> winningStatistics) {
        printNewLine();

        winningStatistics.forEach((description, count) -> {
            System.out.println(description + count + "개");
        });
    }

    @Override
    public void printTotalProfit(final long totalPrize, final long money) {
        double totalProfit = ((double) totalPrize / money * ONE_HUNDRED);
        System.out.println("총 수익률은" + String.format("%.1f", totalProfit) + "%" + "입니다.");
    }

    @Override
    public void printErrorMessage(final String message) {
        System.out.println(message);
    }

    private void printNewLine() {
        System.out.println();
    }
}

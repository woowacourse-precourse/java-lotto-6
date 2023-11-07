package lotto.View;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import lotto.Domain.Lotto;
import lotto.Domain.Rank;
import lotto.Domain.WinningResult;

public class OutputView {
    private final String BUY_LOTTO_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private final String WINNING_NUM_FORMAT = "%d개";
    private final String REVENUE_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private final String WIN_RESULT_MESSAGE = "당첨 통계";
    private final String LINE_DIVIDE_SYMBOL = "---";
    private final String LINE = "\n";
    private final String DASH = " - ";
    private final String SPACE = " ";

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void showNewLine(){
        System.out.println();
    }
    public void showBuyLotto(List<Lotto> buyLotto) {
        System.out.println(String.format(BUY_LOTTO_MESSAGE_FORMAT, buyLotto.size()));
        for (Lotto lotto : buyLotto) {
            System.out.println(lotto);
        }
    }

    public void showWinningResult(WinningResult winningResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(WIN_RESULT_MESSAGE).append(LINE)
                .append(LINE_DIVIDE_SYMBOL).append(LINE)
                .append(makeWinningResultMessage(winningResult));
        System.out.println(stringBuilder.toString());
    }

    public void showRevenue(double revenue) {
        System.out.println(String.format(REVENUE_MESSAGE_FORMAT, revenue));
    }

    private String makeWinningResultMessage(WinningResult winningResult) {
        StringJoiner stringJoiner = new StringJoiner(LINE);
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank!=Rank.NOTHING)
                .forEach(rank -> stringJoiner.add(rank.toString() + DASH + String.format(WINNING_NUM_FORMAT,winningResult.result().getOrDefault(rank,0))));
        return stringJoiner.toString();
    }

}

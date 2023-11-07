package lotto.view;


import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import lotto.model.LottoPaper;
import lotto.model.LottoStats;
import lotto.model.Rank;

public class OutputView {
    private static final String BUY_LOTTO = "구입금액을 입력해 주세요";
    private static final String COUNT_LOTTO = "%d개를 구매했습니다.";
    private static final String PICK_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PICK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String STATS_LOTTO = "당첨 통계\n---";
    private static final String BENEFIT_RATE = "총 수익률은 %.1f%%입니다.";
    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }
    public void printBuyLotto() {
        System.out.println(BUY_LOTTO);
    }

    public void printLottoPapers(List<LottoPaper> papers) {
        printLottoCount(papers.size());

        for(LottoPaper paper : papers) {
            printLottoPaper(paper);
        }
    }

    private void printLottoCount(int count) {
        System.out.println(String.format(COUNT_LOTTO, count));
    }

    private void printLottoPaper(LottoPaper paper) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < paper.numbers().size(); i++) {
            sb.append(paper.numbers().get(i));
            if (i < paper.numbers().size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println(sb);
    }

    public void printPickWinningNumber() {
        System.out.println(PICK_WINNING_NUMBER);
    }

    public void printPickBonusNumber() {
        System.out.println(PICK_BONUS_NUMBER);
    }

    public void printLottoStats(LottoStats stats) {
        System.out.println(STATS_LOTTO);
        for (Entry<Rank, Integer> stat : stats.stats().entrySet()) {
            if (stat.getKey() != Rank.FAIL)
                printLottoStat(stat);
        }
    }

    private void printLottoStat(Entry<Rank, Integer> stat) {
        StringBuilder sb = new StringBuilder();
        sb.append(stat.getKey().getDescription()).append(" - ").append(stat.getValue()).append("개");
        System.out.println(sb);
    }

    public void printBenefitRate(double rate) {
        System.out.println(String.format(BENEFIT_RATE, rate));
    }
}


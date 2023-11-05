package lotto.view;

import java.util.List;
import lotto.constant.PrizeConstant;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String STATISTIC_MESSAGE = "당첨 통계";
    private static final String NEW_LINE = "\n";
    private static final String SPLIT_LINE = "---";
    private static final String PER = "개";
    private static final int START = 3;

    public void printLotto(int quantity, List<List<Integer>> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(quantity + PURCHASE_MESSAGE);

        for (List<Integer> lotto : lottos) {
            sb.append(NEW_LINE).append(lotto);
        }

        System.out.println(sb);
    }

    public void printStatistics(List<Integer> statistics) {
        StringBuilder sb = new StringBuilder();
        sb.append(STATISTIC_MESSAGE).append(NEW_LINE).append(SPLIT_LINE);

        for (int i = START; i < statistics.size(); i++) {
            String message = PrizeConstant.getMessageByScore(i);
            sb.append(NEW_LINE).append(message + statistics.get(i) + PER);
        }

        System.out.println(sb);
    }
}

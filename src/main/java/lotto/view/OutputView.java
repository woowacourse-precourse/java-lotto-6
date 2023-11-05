package lotto.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.constant.PrizeConstant;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String STATISTIC_MESSAGE = "당첨 통계";
    private static final String PROFITABILITY_MESSAGE = "총 수익률은 ";
    private static final String NEW_LINE = "\n";
    private static final String SPLIT_LINE = "---";
    private static final String PER = "개";
    private static final String PERCENT = "%입니다.";
    private static final int START = 3;

    public void printLotto(int quantity, List<List<Integer>> myLottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append(NEW_LINE + quantity + PURCHASE_MESSAGE + NEW_LINE);

        for (List<Integer> myLottoNumber : myLottoNumbers) {
            sb.append(myLottoNumber + NEW_LINE);
        }

        System.out.println(sb);
    }

    public void printStatistics(List<Integer> statistics) {
        StringBuilder sb = new StringBuilder();
        sb.append(NEW_LINE + STATISTIC_MESSAGE).append(NEW_LINE).append(SPLIT_LINE);

        for (int i = START; i < statistics.size(); i++) {
            String message = PrizeConstant.getMessageByScore(i);
            sb.append(NEW_LINE).append(message + statistics.get(i) + PER);
        }

        System.out.println(sb);
    }

    public void printProfitability(float profitability){
        System.out.println(PROFITABILITY_MESSAGE + String.format("%.1f", profitability) + PERCENT);
    }
}

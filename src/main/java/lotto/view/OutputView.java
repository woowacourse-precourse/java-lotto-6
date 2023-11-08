package lotto.view;

import lotto.Lotto;
import lotto.model.Result;

import java.util.*;

public class OutputView {

    public static final String BUY_TICKETS_COUNT = "%d개를 구매했습니다.\n";
    public static final String BR = "\n";
    public static final String OUTPUT_START_MESSAGE = "\n당첨 통계\n---\n";
    public static final String FIFTH = "3개 일치 (%,d원) - %d개\n";
    public static final String FOURTH = "4개 일치 (%,d원) - %d개\n";
    public static final String THIRD = "5개 일치 (%,d원) - %d개\n";
    public static final String SECOND = "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    public static final String FIRST = "6개 일치 (%,d원) - %d개\n";
    public static final String TOTAL_SCORE = "총 수익률은 %.1f%%입니다.";

    public void printLottoTickets(List<Lotto> lottoTickets) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(BUY_TICKETS_COUNT, lottoTickets.size()));

        for (Lotto lotto : lottoTickets) {
            sb.append(lotto.getLottoNumbersToPrint());
            sb.append(BR);
        }

        System.out.println(sb);
    }

    public void printResult(HashMap<Result, Integer> resultMap, double score) {
        StringBuilder sb = new StringBuilder(OUTPUT_START_MESSAGE);
        LinkedHashMap<Result, String> printResultKeyMap = getPrintResultKeySet();

        for (Result result : printResultKeyMap.keySet()) {
            String prizeMessage = printResultKeyMap.get(result);
            int prizeAmount = result.getPrizeMoney();
            int resultCount = resultMap.getOrDefault(result, 0);
            sb.append(String.format(prizeMessage, prizeAmount, resultCount));
        }

        sb.append(String.format(TOTAL_SCORE, score));
        System.out.println(sb);
    }

    private static LinkedHashMap<Result,String> getPrintResultKeySet() {
        LinkedHashMap<Result, String> printedPrizeMap = new LinkedHashMap<>();
        printedPrizeMap.put(Result.FIFTH, FIFTH);
        printedPrizeMap.put(Result.FOURTH, FOURTH);
        printedPrizeMap.put(Result.THIRD, THIRD);
        printedPrizeMap.put(Result.SECOND, SECOND);
        printedPrizeMap.put(Result.FIRST, FIRST);
        return printedPrizeMap;
    }
}

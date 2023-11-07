package lotto.view;

import lotto.model.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class OutputView {
    private static final String BUY_SOME_AMOUNT_OF_LOTTO = "%d개를 구매했습니다.";
    private static final String DELIMITER = ",";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String NEW_LINE = "\n";
    SortedMap<String, String> matchTable;


    public OutputView() {
        this.matchTable = new TreeMap<>(Collections.reverseOrder());
        this.matchTable.put("1st", "6개 일치 (2,000,000,000원)");
        this.matchTable.put("2nd", "5개 일치, 보너스 볼 일치 (30,000,000원)");
        this.matchTable.put("3rd", "5개 일치 (1,500,000원)");
        this.matchTable.put("4th", "4개 일치 (50,000원)");
        this.matchTable.put("5th", "3개 일치 (5,000원)");
    }


    public void printLottoPurchases(List<Lotto> lottos) {
        String lottoList = lottos.stream()
                .map(lotto -> {
                    StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
                    lotto.getNumbers().forEach(number -> stringJoiner.add(number.toString()));
                    return stringJoiner.toString();
                })
                .collect(Collectors.joining(NEW_LINE));

        System.out.println();
        System.out.printf(BUY_SOME_AMOUNT_OF_LOTTO + "\n", lottos.size());
        System.out.println(lottoList);
    }

    public void printDrawStatistics(Map<String, Long> winningResult, double profitRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(makeDrawStatistics(winningResult, profitRate));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private String makeDrawStatistics(Map<String, Long> winningResult, double profitRate) {
        return matchTable.entrySet()
                .stream()
                .map(entry -> {
                    StringJoiner stringJoiner = new StringJoiner(" - ");
                    stringJoiner.add(entry.getValue());
                    if (winningResult.get(entry.getKey()) == null) {
                        stringJoiner.add(String.valueOf(0) + "개");
                    }
                    else {
                        stringJoiner.add(winningResult.get(entry.getKey()).toString() + "개");
                    }
                    return stringJoiner.toString();
                })
                .collect(Collectors.joining(NEW_LINE));
    }


    /**
     * 당첨 통계
     * ---
     * 3개 일치 (5,000원) - 1개
     * 4개 일치 (50,000원) - 0개
     * 5개 일치 (1,500,000원) - 0개
     * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
     * 6개 일치 (2,000,000,000원) - 0개
     * 총 수익률은 62.5%입니다.
     */
}

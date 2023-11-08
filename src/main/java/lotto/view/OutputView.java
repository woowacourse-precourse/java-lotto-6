package lotto.view;

import lotto.model.Lotto;
import lotto.model.Reward;

import java.util.*;
import java.util.stream.Collectors;

public class OutputView {
    private static final String BUY_SOME_AMOUNT_OF_LOTTO = "%d개를 구매했습니다.";
    private static final String DELIMITER_FOR_PURCHASES = ",";
    private static final String DELIMITER_FOR_STATISTICS = " - ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String NEW_LINE = "\n";
    private static final String DRAW_STATISTICS = "당첨 통계";
    private static final String BOUNDARY = "---";
    private static final String COUNT = "개";
    private static final String TOTAL_RATE_ON_RETURN = "총 수익률은 %s%%입니다.";
    private static final String FIRST_DECIMAL_PLACE = "%.1f";

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
        System.out.println();
        System.out.printf(BUY_SOME_AMOUNT_OF_LOTTO.concat(NEW_LINE), lottos.size());
        System.out.println(makeLottoPurchases(lottos));
    }

    private String makeLottoPurchases(List<Lotto> lottos) {
        return lottos.stream().map(lotto -> {
            StringJoiner stringJoiner = new StringJoiner(DELIMITER_FOR_PURCHASES, PREFIX, SUFFIX);
            sortLottoNumbers(lotto.getNumbers()).forEach(number -> stringJoiner.add(number.toString()));
            return stringJoiner.toString();
        }).collect(Collectors.joining(NEW_LINE));
    }

    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().sorted().toList();
    }

    public void printDrawStatistics(Map<String, Long> winningResult, double profitRate) {
        System.out.println();
        System.out.println(DRAW_STATISTICS);
        System.out.println(BOUNDARY);
        System.out.print(makeDrawStatistics(winningResult));
        System.out.printf(TOTAL_RATE_ON_RETURN.concat(NEW_LINE), String.format(FIRST_DECIMAL_PLACE, profitRate));
    }

    private String makeDrawStatistics(Map<String, Long> winningResult) {
        StringBuilder stringBuilder = new StringBuilder();
        winningResult.forEach((rank, count) -> {
            stringBuilder.append(matchTable.get(rank));
            stringBuilder.append(DELIMITER_FOR_STATISTICS);
            stringBuilder.append(count);
            stringBuilder.append(COUNT);
            stringBuilder.append(NEW_LINE);
        });
        return stringBuilder.toString();
    }
}

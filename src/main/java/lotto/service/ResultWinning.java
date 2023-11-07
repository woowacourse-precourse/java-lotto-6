package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultWinning {
    private static final int ZERO = 0;
    private static final int PRINT_COUNT = 4;
    private static final String MESSAGE = "개";
    private static int printCount = 1;
    private static int matchCount = 3;

    private static List<String> winningStatistics = new ArrayList<>();

    public static List<String> makeResult(List<Integer> winningResult) {
        for (int i = ZERO; i < PRINT_COUNT; i++) {
            add(addString(matching(winningResult)));
            if (matchCount == 6) {
                add(addString(Collections.frequency(winningResult, 7)));
            }
        }

        return winningStatistics;
    }

    private static void add(String result) {
        winningStatistics.add(result);
    }

    private static String addString(int match) {
        StringBuilder sb = new StringBuilder();
        sb.append(ResultWinStatus.getIndexMessage(printCount++));
        sb.append(match);
        sb.append(MESSAGE);

        return sb.toString();
    }

    private static int matching(List<Integer> winningResult) {
        return Collections.frequency(winningResult, matchCount++);
    }
}

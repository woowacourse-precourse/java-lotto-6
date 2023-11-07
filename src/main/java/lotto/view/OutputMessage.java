package lotto.view;

import lotto.domain.PrizeTable;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class OutputMessage {
    public static void totalLottoMessage(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public static void viewLottoNumbers(List<Integer> numbers) {
        String result = numbers.stream()
                .map(Object::toString) // Convert integers to strings
                .collect(Collectors.joining(", ", "[", "]")); // Join strings with comma and wrap with []
        System.out.println(result);
    }

    public static void showRankResult(HashMap<PrizeTable, Integer> map) {
        for (PrizeTable rank : PrizeTable.values()) {
            showSingleRankResult(map, rank);
        }
    }

    private static void showSingleRankResult(HashMap<PrizeTable, Integer> map, PrizeTable rank) {
        if (rank.getMatchingNumbers()==0) {
            return;
        }
        if (rank.equals(PrizeTable.SECOND_PRIZE)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    rank.getMatchingNumbers(), rank.getPrizeAmount(), map.get(rank));
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getMatchingNumbers(), rank.getPrizeAmount(), map.get(rank));
    }


}

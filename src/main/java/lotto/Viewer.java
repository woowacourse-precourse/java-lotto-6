package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Viewer {

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            String result = lotto.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("[" + result + "]");
        }
        System.out.println();
    }

    public void printTotalWinningResult(HashMap<Rank, Integer> result) {
        System.out.println("당첨 통계\n---");
        Arrays.stream(Rank.values()).filter(rank -> rank != Rank.MISS)
                .forEach(rank -> printWinningResult(rank.getMessage(), result.get(rank)));
    }

    private void printWinningResult(String message, Integer count) {
        System.out.println(message + count + "개");
    }

    public void printIncomeRating(long purchase, long income) {
        double rate = (double) income / (double) purchase;
        double result = Math.round(rate * 1000) / 10.0;
        System.out.println("총 수익률은 " + result + "%입니다.");
    }

}

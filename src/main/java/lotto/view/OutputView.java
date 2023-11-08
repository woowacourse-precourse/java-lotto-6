package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Player;

import java.util.Map;

public class OutputView {
    public static final void printAmount(int amount) {
        System.out.println("\n" + amount + "개를 구매했습니다.");
    }

    public static final void printLotteries(Player player) {
        for (Lotto lotto : player.generateLotteries()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static final void printResult() {
        System.out.println("\n당첨 통계\n---");
    }

    public static final void printResultList(Map<LottoResult, Integer> map) {
        System.out.println(LottoResult.FIFTH.getMessage() + map.getOrDefault(LottoResult.FIFTH, 0) + "개");
        System.out.println(LottoResult.FOURTH.getMessage() + map.getOrDefault(LottoResult.FOURTH, 0) + "개");
        System.out.println(LottoResult.THIRD.getMessage() + map.getOrDefault(LottoResult.THIRD, 0) + "개");
        System.out.println(LottoResult.SECOND.getMessage() + map.getOrDefault(LottoResult.SECOND, 0) + "개");
        System.out.println(LottoResult.FIRST.getMessage() + map.getOrDefault(LottoResult.FIRST, 0) + "개");
    }

    public static final void printTotalRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}

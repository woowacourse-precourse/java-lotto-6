package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.Lotto;
import lotto.game.LottoGame;
import lotto.game.Result;

public class OutputView {
    private OutputView() {

    }

    public static void printBuyGames(int inputNumber) {
        System.out.println();
        System.out.println(inputNumber + "개를 구매했습니다.");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static String getProfit(int numberOfGames, Map<Result, Integer> resultCount) {
        long sum = 0L;

        for (Entry<Result, Integer> entry : resultCount.entrySet()) {
            sum += (long) entry.getKey().getWinningMoney() * entry.getValue();
        }

        long investMoney = (long) LottoGame.PRICE * numberOfGames;

        return String.format("%.1f", sum * 100.0 / investMoney);
    }

    public static void printResult(int numberOfGames, Map<Result, Integer> resultCount) {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + resultCount.getOrDefault(Result.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + resultCount.getOrDefault(Result.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultCount.getOrDefault(Result.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultCount.getOrDefault(Result.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultCount.getOrDefault(Result.FIRST, 0) + "개");
        System.out.println("총 수익률은 " + getProfit(numberOfGames, resultCount) + "%입니다.");
    }
}

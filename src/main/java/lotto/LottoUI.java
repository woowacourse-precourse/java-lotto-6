package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;

public class LottoUI {
    public static String readLine(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchaseResult(List<Lotto> lottos) {
        printMessage(String.format("%d개를 구매했습니다.%n", lottos.size()));
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void printTotalPrize(HashMap<LottoRank, Integer> lottoResult) {
        for (LottoRank lottoRank : LottoRank.values()) {
            System.out.println(printPrize(lottoRank, lottoResult.get(lottoRank)));
        }
    }

    public static String printPrize(LottoRank lottoRank, int count) {
        String commaPrize = NumberFormat.getInstance().format(lottoRank.getPrize());

        if (lottoRank.isCorrectBonus()) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                    lottoRank.getCorrectCount(),
                    commaPrize,
                    count);
        }

        return String.format("%d개 일치 (%s원) - %d개",
                lottoRank.getCorrectCount(),
                commaPrize,
                count);
    }

    public static void printProfit(double profitRatio) {
        System.out.println("총 수익률은 " + profitRatio + "%입니다.");
    }
}

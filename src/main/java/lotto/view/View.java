package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;
import lotto.constant.RankingMessage;

public class View {
    private static String BAR = " - ";
    private static String UNIT = "개";

    public static int requestMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void newLine() {
        System.out.println();
    }

    public static void seperateLine() {
        System.out.println("---");
    }

    public static void printLottoRank(List<Integer> lottoRank) {
        IntStream.range(0, RankingMessage.values().length)
                .forEach(index -> {
                    int lottoRankIndex = index + 1;
                    int count = lottoRank.get(lottoRankIndex);
                    RankingMessage message = RankingMessage.values()[index];
                    printMessage(message.getMessage() + BAR + count + UNIT);
                });
    }
}

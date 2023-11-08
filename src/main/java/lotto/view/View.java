package lotto.view;

import java.util.List;
import java.util.stream.IntStream;
import lotto.constant.LottoResult;

public class View {
    private static String BAR = " - ";
    private static String UNIT = "개";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void seperateLine() {
        System.out.println("---");
    }

    public static void printLottoRank(List<Integer> lottoRank) {
        IntStream.range(0, LottoResult.values().length)
                .forEach(index -> {
                    int lottoRankIndex = index + 1;
                    int count = lottoRank.get(lottoRankIndex);
                    LottoResult message = LottoResult.values()[index];
                    printMessage(message.getMessage() + count + UNIT);
                });
    }
}

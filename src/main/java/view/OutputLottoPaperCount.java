package view;

import model.LottoPrice;

public class OutputLottoPaperCount {
    private static final String OUTPUT_MESSAGE = "%d개를 구매했습니다.";

    public static void printBuyLotto(LottoPrice lottoPrice) {
        System.out.printf((OUTPUT_MESSAGE) + "%n", lottoPrice.lottoPaperCount());
    }
}
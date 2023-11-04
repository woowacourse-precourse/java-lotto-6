package lotto;

import java.util.HashMap;

public class OutputView {
    private static final String OUTPUT_LOTTO_PERCHASED_COUNT = "%d개를 구매했습니다.";
    private static final String OUTPUT_LOTTO_WINNING_STATICS_MESSAGE = "당첨 통계\n---";
    private static final String OUTPUT_LOTTO_TOTAL_RATE_OF_RETURN = "총 수익률은 %f%%입니다.";

    public static void printLottoPurchasedCount(int numberOfPurchasedCount){
        System.out.printf(OUTPUT_LOTTO_PERCHASED_COUNT, numberOfPurchasedCount);
    }

    public static void printStatics(HashMap<LottoData, Integer> lotteryData) {
        System.out.println(OUTPUT_LOTTO_WINNING_STATICS_MESSAGE);

        for (LottoData lottoData : LottoData.getValues()) {
            System.out.println(lottoData.getStaticsMessage(lotteryData.get(lottoData)));
        }
    }

    public static void printRateOfReturn(float rateOfReturn) {
        System.out.printf(OUTPUT_LOTTO_TOTAL_RATE_OF_RETURN, rateOfReturn);
    }

}

package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputMessage {
    private static final String PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String RESULT_TOP_MESSAGE = "당첨 통계" + "\n" + "---";
    private static final String RESULT_NUMBER_MESSAGE = " - %d개";
    private static final String RESULT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";



    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf(PURCHASE_RESULT_MESSAGE, lottos.size());
        lottos.forEach(number -> System.out.println(number.getNumbers()));
    }

    public static void printLottoResult(LottoResult lottoResult) {
        List<LottoRank> ranks = Arrays.asList(LottoRank.values());
        Collections.reverse(ranks);
        System.out.println(RESULT_TOP_MESSAGE);

        ranks.stream()
                .skip(1)
                .forEach(lottoRank -> {
                    String message = String.format(RESULT_NUMBER_MESSAGE, lottoResult.getCount(lottoRank));
                    System.out.println(lottoRank.getMessage() + message);
                });
    }
    public static void printLottoProfit(double rate){
        String message = String.format(RESULT_RATE_MESSAGE,rate);
        System.out.println(message);
    }

}

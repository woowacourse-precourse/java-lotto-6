package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Payment;

import java.util.List;

public class OutputView {
    private static final String PRINT_LOTTO_AMOUNT_SENTENCE = "개를 구매했습니다.";
    private static final String PRINT_RESULT_START_SENTENCE = "당첨 통계";
    private static final String DEFAULT_WINNING_SENTENCE = "%d개 일치 (%d원) - %d개";
    private static final String BONUS_WINNING_SENTENCE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String RETURN_RATE_SENTENCE = "총 수익률은 %s%%입니다.";
    private static final String EMPTY_LINE = "";
    private static final String DASH = "-";

    public static void printGeneratedLottos(Lottos lottos) {
        System.out.println(EMPTY_LINE);
        printLottosAmount(lottos.getLottosAmount());
        printLottosNumber(lottos.getLottosAllSortedNumber());

    }

    private static void printLottosAmount(int amount) {
        StringBuilder sb = new StringBuilder();
        sb.append(amount);
        sb.append(PRINT_LOTTO_AMOUNT_SENTENCE);
        System.out.println(sb);
    }

    private static void printLottosNumber(List<String> lottos) {
        lottos.stream()
                .forEach(lotto -> System.out.println(lotto));
        System.out.println(EMPTY_LINE);
    }

    public static void printWinningResult(LottoResult result) {
        System.out.println(EMPTY_LINE);
        System.out.println(PRINT_RESULT_START_SENTENCE);
        System.out.println(DASH.repeat(3));

        printRankCount(result);
    }

    private static void printRankCount(LottoResult result) {
        //TODO: 당첨 내역 출력


    }

    public static void printReturnRate(String result) {
        System.out.println(result);
    }

}

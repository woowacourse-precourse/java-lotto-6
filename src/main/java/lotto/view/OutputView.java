package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public static final String PURCHASE_NUMBER_FORMAT = "개를 구매했습니다.";
    public static final String WINNING_STATISTIC_FORMAT = "당첨 통계\n---";
    public static final String OPEN_BRACKET = "[";
    public static final String CLOSE_BRACKET = "]";

    public static void printTotalLottoNumber(int totalLottoNumber) {
        System.out.println(totalLottoNumber + PURCHASE_NUMBER_FORMAT);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(makeLottoOutputContent(lotto)));
    }

    public static void printTotalEarningsRate(String earningRate) {
        System.out.printf("총 수익률은 %s입니다.\n%n", earningRate);
    }


    private static String makeLottoOutputContent(Lotto lotto) {
        List<String> lottoNumbers = convertIntegersToStrings(lotto.getNumbers());
        return OPEN_BRACKET + String.join(", ", lottoNumbers) + CLOSE_BRACKET;
    }

    private static List<String> convertIntegersToStrings(List<Integer> integers) {
        return integers.stream().map(integer -> Integer.toString(integer)).toList();
    }

}

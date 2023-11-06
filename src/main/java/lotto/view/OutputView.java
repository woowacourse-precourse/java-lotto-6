package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class OutputView {

    public static void printPurchaseResult(int lottoCount, Lottos lottos) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        printEachLotto(lottos);
    }

    private static void printEachLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printJoiningNumber(lotto.getNumbers());
        }
    }

    private static void printJoiningNumber(List<Integer> sortedNumbers) {
        String formattedString = sortedNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(formattedString);
    }

    public static void printLottoResult(Map<LottoResult, Integer> resultStorage) {
        printResultStartMessage();

        for (LottoResult lottoResultValue : LottoResult.values()) {
            printEachLottoResult(lottoResultValue, resultStorage.get(lottoResultValue));
        }
    }

    private static void printEachLottoResult(LottoResult lottoResultValue, int count) {

        if (lottoResultValue.equals(LottoResult.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", lottoResultValue.getMatchCount()
                    , convertToDecimalFormat(lottoResultValue.getPrize()), count);
            return;
        }

        System.out.printf("%d개 일치 (%s원) - %d개\n", lottoResultValue.getMatchCount()
                , convertToDecimalFormat(lottoResultValue.getPrize()), count);
    }


    private static String convertToDecimalFormat(int prize) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(prize);
    }

    private static void printResultStartMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printRateOfReturn(int balance, long prizeAmount) {
        double rateOfReturn = (prizeAmount) / (double) balance * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }
}

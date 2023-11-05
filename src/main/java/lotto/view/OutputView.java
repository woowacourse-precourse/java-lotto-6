package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoResult;

public class OutputView {

    public static void printUserLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(changeLottoToString(lotto.getNumbers()));
        }
        System.out.println();
    }

    public static void printLottoStatistics(List<LottoResult> lottoResults, double gainStatistic) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(makeResultsToString(lottoResults));
        System.out.println("총 수익률은 " + gainStatistic + "%입니다.");
    }

    private static String changeLottoToString(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private static String makeResultsToString(List<LottoResult> results) {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat decFormat = new DecimalFormat("###,###");

        for (LottoResult lottoResult : LottoResult.values()) {
            long count = results.stream().filter(res -> res == lottoResult).count();
            stringBuilder.append(lottoResult.getRule())
                    .append(" (" + decFormat.format(lottoResult.getPrize()) + "원)")
                    .append(" - ")
                    .append(count)
                    .append("개")
                    .append("\n");
        }

        return stringBuilder.toString();
    }
}

package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoResult;

public class OutputView {

    private static final String STATISTIC_FORMAT = "%.1f";
    private static final String DECIMAL_FORMAT = "###,###";
    private static final String SPLIT_SENTENCE = ", ";
    private static final String PREFIX_SENTENCE = "[";
    private static final String SUFFIX_SENTENCE = "]";

    private OutputView() {
    }

    public static void printUserLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(changeLottoToString(lotto.numbers())));
        System.out.println();
    }

    public static void printLottoStatistics(List<LottoResult> lottoResults, double gainStatistic) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(makeResultsToString(lottoResults));
        System.out.println("총 수익률은 " + String.format(STATISTIC_FORMAT, gainStatistic) + "%입니다.");
    }

    private static String changeLottoToString(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(SPLIT_SENTENCE, PREFIX_SENTENCE, SUFFIX_SENTENCE));
    }

    private static String makeResultsToString(List<LottoResult> userResults) {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat decFormat = new DecimalFormat(DECIMAL_FORMAT);

        for (LottoResult lottoResultFormat : LottoResult.getLottoResultWithoutDefault()) {
            stringBuilder.append(lottoResultFormat.getRule()).append(" (")
                    .append(decFormat.format(lottoResultFormat.getPrize())).append("원) - ")
                    .append(countEqualResult(userResults, lottoResultFormat)).append("개\n");
        }
        return stringBuilder.toString();
    }

    private static long countEqualResult(List<LottoResult> results, LottoResult lottoResult) {
        return results.stream()
                .filter(Objects::nonNull)
                .filter(res -> res.equals(lottoResult)).count();
    }
}

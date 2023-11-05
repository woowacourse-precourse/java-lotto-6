package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.message.LottoResult;
import lotto.message.Output;

public class OutputView {

    public static void printIssueResults(List<Lotto> lottos) {
        Output.ISSUED_LOTTO_COUNT.print(lottos.size());
        lottos.forEach(Lotto::printNumbers);
    }

    public static void printGameResult(Map<LottoResult, Integer> result, double yieldRate) {
        Set<LottoResult> lottoResults = result.keySet();

        Output.RESULT.print();
        lottoResults.forEach(
                lottoResult -> {
                    Integer count = result.get(lottoResult);
                    lottoResult.print(count);
                }
        );
        Output.TOTAL_RETURN.print(yieldRate);
    }
}

package lotto.view;

import java.util.Map;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.message.LottoResult;
import lotto.message.Output;

public class OutputView {

    public static void printIssueResults(Lottos lottos) {
        Output.ISSUED_LOTTO_COUNT.print(lottos.getPurchaseQuantity());
        lottos.getLottos().forEach(Lotto::printNumbers);
    }

    public static void printGameResult(Map<LottoResult, Integer> winningCount, double yieldRate) {
        Set<LottoResult> lottoResults = winningCount.keySet();

        Output.RESULT.print();
        lottoResults.forEach(
                lottoResult -> {
                    Integer count = winningCount.get(lottoResult);
                    lottoResult.print(count);
                }
        );
        Output.TOTAL_YIELD.print(yieldRate);
    }
}

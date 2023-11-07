package lotto.view;

import java.text.NumberFormat;
import java.util.Locale;
import lotto.dto.LottoResult;
import lotto.dto.LottosResult;
import lotto.dto.TotalResult;
import lotto.dto.TotalResults;

public class OutputView {
    private static final String PRINT_LOTTO_MESSAGE = "%d개를 구매했습니다.";
    private static final String PRINT_RESULTS_MESSAGE = "당첨 통계\n---";
    private static final String PRINT_RATE_OF_RETURN_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String PRINT_BONUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PRINT_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";

    public void printLottos(LottosResult result) {
        System.out.println(PRINT_LOTTO_MESSAGE.formatted(result.lottosCount()));
        for (LottoResult lottoResult : result.lottoResults()) {
            System.out.println(lottoResult.lottoNumbers());
        }
    }

    public void printResults(TotalResults totalResults) {
        System.out.println(PRINT_RESULTS_MESSAGE);
        for (TotalResult totalResult : totalResults.totalResults()) {
            if (totalResult.isBonus()) {
                printBonusResult(totalResult);
                continue;
            }
            printResult(totalResult);
        }
        System.out.println(PRINT_RATE_OF_RETURN_MESSAGE.formatted(totalResults.rateOfReturn()));
    }

    private void printBonusResult(TotalResult totalResult) {
        String formattedAmounts = getFormattedAmounts(totalResult.amounts());
        System.out.println(PRINT_BONUS_RESULT_MESSAGE.formatted(totalResult.matchCount(), formattedAmounts,
                totalResult.winningLottoCount()));
    }

    private void printResult(TotalResult totalResult) {
        String formattedAmounts = getFormattedAmounts(totalResult.amounts());
        System.out.println(PRINT_RESULT_MESSAGE.formatted(totalResult.matchCount(), formattedAmounts,
                totalResult.winningLottoCount()));
    }

    private String getFormattedAmounts(int amounts) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        return numberFormat.format(amounts);
    }
}

package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.LottoResult;
import lotto.dto.LottoResults;

public class Output {
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String RESULTS_HEADER = "\n당첨 통계\n---\n";
    private static final String RESULT_FORMAT = "%d개 일치%s (%,d원) - %d개\n";
    private static final String RETURN_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String EMPTY_MESSAGE = "";
    private static final String NEW_LINE = "\n";

    private Output() {
    }

    public static void printPurchasedLottoNumbers(List<Lotto> lottos) {
        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append(String.format(LOTTO_COUNT_MESSAGE, lottos.size()));

        for (Lotto lotto : lottos) {
            resultStringBuilder.append(lotto.getNumbers()).append(NEW_LINE);
        }

        resultStringBuilder.append(NEW_LINE);
        System.out.println(resultStringBuilder);
    }

    public static void printResults(LottoResults lottoResults) {
        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append(RESULTS_HEADER);

        lottoResults.lottoResults().forEach(result -> resultStringBuilder.append(getResultString(result)));

        double returnRate = lottoResults.returnRate();
        resultStringBuilder.append(String.format(RETURN_RATE_FORMAT, returnRate * 100));

        System.out.println(resultStringBuilder);
    }

    private static String getResultString(LottoResult result) {
        int matchCount = result.matchingNumbers();
        int prizeMoney = result.prizeAmount();
        int count = result.numberOfWins();
        boolean hasBonus = result.hasMatchingBonusNumber();
        String bonusMatchMessage = getBonusMessage(hasBonus);

        return String.format(RESULT_FORMAT, matchCount, bonusMatchMessage, prizeMoney, count);
    }

    private static String getBonusMessage(boolean hasBonus) {
        if (hasBonus) {
            return BONUS_MESSAGE;
        }

        return EMPTY_MESSAGE;
    }
}
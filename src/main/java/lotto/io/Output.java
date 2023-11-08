package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoStore;
import lotto.domain.WinningStatistics;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Output {
    private static final String STATICS_HEADER = "당첨 통계\n---";
    private static final String PURCHASE_AMOUNT_PROMPT_MSG = "구입금액을 입력해 주세요.";
    private static final String LOTTO_ANSWER_PROMPT_MSG = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT_MSG = "보너스 번호를 입력해 주세요.";
    private static final String RETURN_RATIO_MSG = "총 수익률은 %.1f%%입니다.";
    private static final String MATCHING_RESULT_MSG = "%d개 일치 (%,d원) - %d개%n";
    private static final String MATCHING_RESULT_WITH_BONUS_MSG = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";

    public static void displayPurchaseAmountPrompt() {
        System.out.println(PURCHASE_AMOUNT_PROMPT_MSG);
    }

    public static void displayLottoStoreNumbers(LottoStore lottoStore) {
        int lottoAmounts = lottoStore.getLottoAmounts();
        System.out.println(lottoAmounts + "개를 구매했습니다.");
        for (Lotto lotto : lottoStore.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void displayLottoAnswerPrompt() {
        System.out.println(LOTTO_ANSWER_PROMPT_MSG);
    }

    public static void displayBonusNumberPrompt() {
        System.out.println(BONUS_NUMBER_PROMPT_MSG);
    }

    public static void displayStatisticsHeader() {
        System.out.println(STATICS_HEADER);
    }

    public static void displayMatchingResult(WinningStatistics winningStatistics) {
        Map<LottoPrize, Integer> result = winningStatistics.getMatchingResult();
        List<LottoPrize> lottoPrizes = LottoPrize.getReverseLottoPrize();
        for (LottoPrize prize : lottoPrizes) {
            int count = result.get(prize);
            long prizeAmount = prize.getPrize();
            int matchingNumbers = prize.getMatchingNumbers();
            String message = getMatchingResultMessage(prize);
            System.out.printf(message, matchingNumbers, prizeAmount, count);
        }
    }

    private static String getMatchingResultMessage(LottoPrize prize) {
        if (prize.equals(LottoPrize.SECOND)) {
            return MATCHING_RESULT_WITH_BONUS_MSG;
        }
        return MATCHING_RESULT_MSG;
    }

    public static void displayReturnRatio(WinningStatistics winningStatistics) {
        double returnRate = winningStatistics.getReturnRate();
        System.out.printf(RETURN_RATIO_MSG + "%n", returnRate);
    }
}

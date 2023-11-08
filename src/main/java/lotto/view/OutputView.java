package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRankInfo;
import lotto.domain.LottoReturnRate;
import lotto.domain.LottoTickets;

import java.text.NumberFormat;
import java.util.*;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String PURCHASE_LOTTO_TICKETS = "개를 구매했습니다.";
    private static final String WINNING_RESULT = "\n당첨 통계\n---";
    private static final String MATCHING_COUNT = "개 일치";
    private static final String MATCHING_BONUS = ", 보너스 볼 일치";
    private static final String PRIZE_MONEY_FORMAT_FRONT = " (";
    private static final String PRIZE_MONEY_FORMAT_BACK = "원) - ";
    private static final String RANK_COUNT = "개";
    private static final String RETURN_RATE_ANNOUNCE_FRONT = "총 수익률은 ";
    private static final String RETURN_RATE_ANNOUNCE_BACK = "%입니다.";
    private static final String RETURN_RATE_PERCENTAGE_FORMAT = "%.1f";

    public void printPurchasedLottoTickets(LottoTickets lottoTickets) {
        System.out.println(NEW_LINE + lottoTickets.getLottoTickets().size() + PURCHASE_LOTTO_TICKETS);
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    public void printWinningResult(Map<LottoRankInfo, Integer> winningResult, List<LottoRankInfo> rankInfos) {
        System.out.println(WINNING_RESULT);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

        for (LottoRankInfo rankInfo : rankInfos) {
            System.out.print(rankInfo.getMatchingCount() + MATCHING_COUNT);
            if (rankInfo.equals(LottoRankInfo.SECOND)) {
                System.out.print(MATCHING_BONUS);
            }

            String formattedPrizeMoney = numberFormat.format(rankInfo.getPrizeMoney());
            System.out.print(PRIZE_MONEY_FORMAT_FRONT + formattedPrizeMoney + PRIZE_MONEY_FORMAT_BACK);
            System.out.println(winningResult.get(rankInfo) + RANK_COUNT);
        }
    }

    public void printReturnRate(LottoReturnRate lottoReturnRate) {
        System.out.println(RETURN_RATE_ANNOUNCE_FRONT + String.format(RETURN_RATE_PERCENTAGE_FORMAT, lottoReturnRate.getReturnRate()) + RETURN_RATE_ANNOUNCE_BACK);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}

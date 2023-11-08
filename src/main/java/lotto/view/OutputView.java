package lotto.view;

import lotto.domain.LottoPurchaseMoney;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.dto.LottoTicketDto;
import lotto.dto.LottoTicketsDto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {
    private static final String EARNINGS_RATE_FORMAT = "#,###.#";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printLottoTickets(LottoTicketsDto lottoTicketsDto) {
        System.out.println(System.lineSeparator() + lottoTicketsDto.getTotalCount() + "개를 구매했습니다.");
        for (LottoTicketDto lottoTicketDto : lottoTicketsDto.getLottoTickets()) {
            System.out.println(lottoTicketDto.getLottoNumbers());
        }
    }

    public static void printLottoResult(LottoResult lottoResult, LottoPurchaseMoney lottoPurchaseMoney) {
        System.out.println(System.lineSeparator() + "당첨 통계\n" + "---");
        for (Rank rank : getReversedRanks()) {
            if (rank.equals(Rank.BLANK)) continue;
            System.out.println(rank.getWinningMessage() + lottoResult.getRankCount(rank) + "개");
        }
        String earningsRate = earningsRateFormatter(lottoResult.getTotalEarningsRate(lottoPurchaseMoney));
        System.out.println("총 수익률은 " + earningsRate + "%입니다.");
    }

    private static List<Rank> getReversedRanks() {
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);
        return ranks;
    }

    private static String earningsRateFormatter(double earningsRate) {
        DecimalFormat format = new DecimalFormat(EARNINGS_RATE_FORMAT);
        return format.format(earningsRate);
    }

}

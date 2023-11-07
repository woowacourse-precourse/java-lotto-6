package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void print(int purchaseQuantity) {
        final String MESSAGE = "개를 구매했습니다.";
        System.out.println(purchaseQuantity + MESSAGE);
    }

    public void print(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public void print(Map<Prize, Integer> prizeStatistics) {
        final String HEADER = "당첨 통계";
        final String SEPARATOR = "---------";

        System.out.println(HEADER);
        System.out.println(SEPARATOR);

        for (Map.Entry<Prize, Integer> prizeStatistic : prizeStatistics.entrySet()) {
            Prize prize = prizeStatistic.getKey();
            if (prize.equals(Prize.NONE)) {
                continue;
            }
            int prizeCount = prizeStatistic.getValue();

            String message = buildPrizeMessage(prize, prizeCount);
            System.out.println(message);
        }
    }

    private String buildPrizeMessage(Prize prize, int prizeCount) {
        final String COUNT_FORMAT = "개 ";
        final String MATCHED_COUNT_FORMAT = COUNT_FORMAT + "일치 ";
        final String FIRST_ROUND_BRACKETS = "(";
        final String LAST_ROUND_BRACKETS = ")";
        final String PRIZE_MONEY_FORMAT = "원";
        final String DASH_FORMAT = " - ";

        String matchedCountMessage = prize.matchedCount + MATCHED_COUNT_FORMAT;
        String prizeMoneyMessage = FIRST_ROUND_BRACKETS + formatPrizeMoney(prize.prizeMoney) + PRIZE_MONEY_FORMAT + LAST_ROUND_BRACKETS;
        String countMessage = DASH_FORMAT + prizeCount + COUNT_FORMAT;

        return matchedCountMessage + prizeMoneyMessage + countMessage;
    }

    private String formatPrizeMoney(int prizeMoney) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(prizeMoney);
    }
}

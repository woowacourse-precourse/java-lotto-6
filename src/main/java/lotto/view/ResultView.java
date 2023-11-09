package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTickets;

public class ResultView {

    private static final String OUTPUT_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String OUTPUT_WINNING_STATISTICS = "당첨 통계";
    private static final String DIVIDING_LINE = "---";
    private static final String THREE_MATCHES = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCHES = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCHES = "5개 일치 (1,500,000원) - ";
    private static final String BONUS_MATCHES = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_MATCHES = "6개 일치 (2,000,000,000원) - ";
    private static final String[] MATCHES_MESSAGE = {THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, BONUS_MATCHES,
            SIX_MATCHES};
    private static final String COUNT = "개";
    private static final int FIRST = 2000000000;
    private static final int SECOND = 30000000;
    private static final int THIRD = 1500000;
    private static final int FOURTH = 50000;
    private static final int FIFTH = 5000;
    private static final int[] PRIZE_MONEY = {FIFTH, FOURTH, THIRD, SECOND, FIRST};
    private static final String TOTAL_RETURN_START = "총 수익률은 ";
    private static final String TOTAL_RETURN_END = "%입니다.";
    public static void printLottoTickets(LottoTickets lottoTickets) {
        List<Lotto> tickets = lottoTickets.getLottoTickets();
        System.out.println(tickets.size() + OUTPUT_COUNT_MESSAGE);
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println(tickets.get(i).getNumbers());
        }
    }

    public static void printWinningsResult(LottoTickets lottoTickets, LottoResult lottoResult) {
        List<Integer> ranks = lottoResult.compareWithLottoTickets(lottoTickets);
        System.out.println(OUTPUT_WINNING_STATISTICS);
        System.out.println(DIVIDING_LINE);
        int totalAmount = 0;
        for (int i = 0; i < ranks.size(); i++) {
            System.out.println(MATCHES_MESSAGE[i] + ranks.get(i) + COUNT);
            totalAmount += (PRIZE_MONEY[i] * ranks.get(i));
        }

        double totalReturn = ((double) totalAmount / (lottoTickets.getTicketsCount() * lottoTickets.getPrice())) * 100;
        System.out.println("totalReturn = " + totalReturn);
        totalReturn = Math.round(totalReturn * 100.0) / 100.0;
        System.out.println(TOTAL_RETURN_START + totalReturn + TOTAL_RETURN_END);
    }
}

package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameResult {

    private static final String OUTPUT_WINNING_STATISTICS = "당첨 통계";
    private static final String DIVIDING_LINE = "---";
    private static final String THREE_MATCHES = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCHES = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCHES = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_PLUS_BONUS_MATCHES = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_MATCHES = "6개 일치 (2,000,000,000원) - ";
    private static final String TOTAL_RETURN_START = "총 수익률은 ";
    private static final String TOTAL_RETURN_END = "%입니다.";
    private static final int ZERO = 0;
    private static final int FIVE = 5;
    private final List<Integer> winningNumber;
    private final LottoTicket lottoTickets;
    private List<Integer> winningNumberCounts = new ArrayList<>();

    public GameResult(List<Integer> winningNumber, LottoTicket lottoTicket) {
        this.winningNumber = winningNumber;
        this.lottoTickets = lottoTicket;
        initWinningNumberCounts();
    }

    private void initWinningNumberCounts() {
        for (int i = ZERO; i < FIVE; i++) {
            winningNumberCounts.add(ZERO);
        }
    }

    public void showResult() {
        System.out.println("winningNumber = " + winningNumber);
        System.out.println(OUTPUT_WINNING_STATISTICS);
        System.out.println(DIVIDING_LINE);

        int totalCount = 0; // 총 수익 계산을 위한 변수
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            int matchedNumbers = countMatchedNumbers(lotto);
            if (matchedNumbers == 6) {
                if (lotto.containsBonusNumber(winningNumber.get(6))) {
                    winningNumberCounts.set(3, winningNumberCounts.get(3) + 1); // 2등
                    totalCount += 30000000;
                } else {
                    winningNumberCounts.set(2, winningNumberCounts.get(2) + 1); // 1등
                    totalCount += 2000000000;
                }
            } else if (matchedNumbers == 5) {
                winningNumberCounts.set(1, winningNumberCounts.get(1) + 1); // 3등
                totalCount += 1500000;
            }
            else if (matchedNumbers == 4) {
                winningNumberCounts.set(1, winningNumberCounts.get(1) + 1); // 4등
                totalCount += 50000;
            } else if (matchedNumbers == 3) {
                winningNumberCounts.set(0, winningNumberCounts.get(0) + 1); // 5등
                totalCount += 5000;
            }
        }

        System.out.println(THREE_MATCHES + winningNumberCounts.get(0) + "개");
        System.out.println(FOUR_MATCHES + winningNumberCounts.get(1) + "개");
        System.out.println(FIVE_MATCHES + winningNumberCounts.get(2) + "개");
        System.out.println(FIVE_PLUS_BONUS_MATCHES + winningNumberCounts.get(3) + "개");
        System.out.println(SIX_MATCHES + winningNumberCounts.get(4) + "개");
        System.out.println("lottoTickets = " + lottoTickets.getPurchaseAmount());
        System.out.println("lottoTickets = " + lottoTickets.getLottoTicketCount());
        double totalReturn = ((double) totalCount / lottoTickets.getPurchaseAmount()) * 100;
        totalReturn = Math.round(totalReturn * 100.0) / 100.0;
        System.out.println(TOTAL_RETURN_START + totalReturn + TOTAL_RETURN_END);
    }

    private int countMatchedNumbers(Lotto lotto) {
        int matchedNumbers = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumber.contains(number)) {
                matchedNumbers++;
            }
        }
        return matchedNumbers;
    }

}
package lotto;

import java.util.List;

public class LottoGame {
    private final LottoTicket lottoTicket;
    private final WinningNumbers winningNumbers;

    public LottoGame(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        this.lottoTicket = lottoTicket;
        this.winningNumbers = winningNumbers;
    }

    public void play() {
        System.out.println("당첨 통계");
                System.out.println("---");

        int totalPrize = 0;
        int[] matchCounts = new int[7];
        for (Lotto lotto : lottoTicket.getLottos()) {
            int matchCount = winningNumbers.countMatchingNumbers(lotto);
            boolean bonusMatch = winningNumbers.isBonusMatching(lotto);

            Prize prize = Prize.valueOf(matchCount, bonusMatch);
            totalPrize += prize.money;
            matchCounts[matchCount] = matchCounts[matchCount] + 1;
        }

        for(int i = 3; i <= 6; i++) {
            if (i == 5) {
                Prize prize = Prize.valueOf(i, true);
                System.out.println(prize + " - " + matchCounts[i] + "개");
            }
            Prize prize = Prize.valueOf(i, false);
            System.out.println(prize + " - " + matchCounts[i] + "개");
        }

        int purchaseAmount = lottoTicket.getLottos().size() * 1000;
        double earningRate = (double) totalPrize / purchaseAmount * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate);
    }
}

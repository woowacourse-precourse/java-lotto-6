package lotto.domain;

import java.util.List;

public class LottoGame {

    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int[] winner = new int[5];

    private static final int MATCH_3_PRIZE = 5000;
    private static final int MATCH_4_PRIZE = 50000;
    private static final int MATCH_5_PRIZE = 1500000;
    private static final int MATCH_5_WITH_BONUS_PRIZE = 30000000;
    private static final int MATCH_6_PRIZE = 2000000000;
    private static final int TICKET_PRICE_PER_LOTTO = 1000;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void printLottoResult() {
        countMatchingLottos();
        System.out.println("당첨 통계\n---\n");
        System.out.printf("3개 일치 (5,000원) - %d개%n", winner[0]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", winner[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", winner[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", winner[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", winner[4]);
        System.out.printf("총 수익률은 %.2f%%입니다.", calculateProfitRate());

    }

    private void countMatchingLottos() {
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers());
            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 3) {
                winner[0]++;
            } else if (matchCount == 4) {
                winner[1]++;
            } else if (matchCount == 5) {
                winner[2]++;
            } else if ((matchCount == 5) && hasBonusNumber) {
                winner[3]++;
            } else if (matchCount == 6) {
                winner[4]++;
            }
        }
    }

    private int countMatchingNumbers(List<Integer> numbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private int calculateTotalPrize() {
        return winner[0] * MATCH_3_PRIZE + winner[1] * MATCH_4_PRIZE + winner[2] * MATCH_5_PRIZE
                + winner[3] * MATCH_5_WITH_BONUS_PRIZE + winner[4] * MATCH_6_PRIZE;
    }

    private double calculateProfitRate() {
        int totalPrize = calculateTotalPrize();
        int totalAmount = lottos.size() * TICKET_PRICE_PER_LOTTO;
        return ((double) totalPrize / totalAmount) * 100;
    }
}

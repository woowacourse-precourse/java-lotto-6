package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultManager {
    private static final int MAX_CHOICES = 6;

    public void viewLottos(List<Lotto> lottos) {
        System.out.println("\n"+lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto: lottos) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getLottoNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }
    
    public void calculatePrizes(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCounts = new int[MAX_CHOICES];

        for (Lotto lotto : lottos) {
            int matchCount = calculateMatchCount(lotto, winningNumbers);
            boolean hasBonusMatch = lotto.getLottoNumbers().contains(bonusNumber);

            switch (matchCount) {
                case 3:
                    matchCounts[0]++;
                    break;
                case 4:
                    matchCounts[1]++;
                    break;
                case 5:
                    if (hasBonusMatch) {
                        matchCounts[3] ++;
                    } else {
                        matchCounts[2]++;
                    }
                    break;
                case 6:
                    matchCounts[4]++;
                    break;
            
                default:
                    break;
            }
        }

        displayResults(matchCounts, lottos.size());
    }

    private int calculateMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;

        for (int number : lotto.getLottoNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount ++;
            }
        }
        return matchCount;
    }

    private void displayResults(int[] matchCounts, int lottoNumber) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchCounts[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts[4] + "개");

        int totalPrize = matchCounts[0] * 5000 + matchCounts[1] * 50000 + matchCounts[2] * 1500000 +
                        matchCounts[3] * 30000000 + matchCounts[4] * 2000000000;
        int purchaseAmount = lottoNumber * 1000;
        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        System.out.println("총 수익률은 " +String.format("%.1f", profitRate)+"%입니다.");
    }
}

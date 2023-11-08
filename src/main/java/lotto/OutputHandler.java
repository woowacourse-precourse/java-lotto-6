package lotto;

import java.text.NumberFormat;
import java.util.List;

public class OutputHandler {

    public static void outputPurchaseAmount(int amount) {
        System.out.println(amount / 1000 + "개를 구매했습니다.");
    }
    public static int countMatchedNumbers(List<Integer> userLotto, List<Integer> winningNums) {
        int count = 0;

        for (int i = 0; i < winningNums.size() - 1; i++) {
            if (userLotto.contains(winningNums.get(i))) {
                count++;
            }
        }
        return count;
    }
    public static int calculateEarnings(int matchedCount, boolean isBonusMatched) {
        Prize prize = Prize.NONE;

        if (matchedCount == 6) {
            prize = Prize.FIRST;
        } else if (matchedCount == 5) {
            if (isBonusMatched) {
                prize = Prize.SECOND;
            } else if(!isBonusMatched){
                prize = Prize.THIRD;
            }
        } else if (matchedCount == 4) {
            prize = Prize.FOURTH;
        } else if (matchedCount == 3) {
            prize = Prize.FIFTH;
        }

        return prize.getPrizeMoney();
    }


    public static void printWinningResult(List<List<Integer>> userLottoList, List<Integer> winningNums) {
        int totalEarnings = 0;
        int[] winningCounts = new int[5];

        // 매치된 개수에 따라 출력 순서를 변경
        for (List<Integer> userLotto : userLottoList) {
            int matchedCount = countMatchedNumbers(userLotto, winningNums);
            boolean isBonusMatched = userLotto.contains(winningNums.get(winningNums.size() - 1));

            int earnings = calculateEarnings(matchedCount, isBonusMatched);
            totalEarnings += earnings;

            if (matchedCount >= 3) {
                winningCounts[matchedCount - 3]++;
            }
        }

        // 당첨 통계 출력
        System.out.println("\n당첨 통계\n---");
        for (int i = 4; i >= 0; i--) {
            Prize prize = Prize.values()[i];
            String prizeDesc = i == 1 ? prize.getMatchedCount() + "개 일치, 보너스 볼 일치" : prize.getMatchedCount() + "개 일치";
            System.out.println(prizeDesc + " (" +
                    NumberFormat.getInstance().format(prize.getPrizeMoney()) + "원) - " + winningCounts[4 - i] + "개");
        }

        double earningRate = (totalEarnings / (double) (userLottoList.size() * 1000)) * 100;
        System.out.println("총 수익률은 " + NumberFormat.getInstance().format(earningRate) + "%입니다.");
    }
}

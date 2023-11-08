package lotto.view;

import java.util.List;

public class OutputView {

    public void displayPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public void printInfo(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void displayWinningResults(int prizeMatchingCount, String prizeAmount, Long winningCount) {
        if (prizeMatchingCount != 7) {
            System.out.println(prizeMatchingCount + "개 일치" + "(" + prizeAmount + "원) - " + winningCount + "개");
        }
        if (prizeMatchingCount == 7) {
            System.out.println("5개 일치 보너스 번호 일치 (" + prizeAmount + "원) - " + winningCount + "개");
        }
    }

    public void displayProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "% 입니다");
    }
}

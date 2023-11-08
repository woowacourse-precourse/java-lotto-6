package lotto.view;

import lotto.domain.WinningPrize;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void displayPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount+"개를 구매했습니다.");
    }

    public void printInfo(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void displayWinningResults(Map<Long, Long> winningInfo) {
        LinkedHashMap<Integer, String> lottoPrizes = WinningPrize.getPrizeMap();

        for (Map.Entry<Integer, String> prizeEntry : lottoPrizes.entrySet()) {
            int prizeMatchingCount = prizeEntry.getKey();
            String prizeAmount = prizeEntry.getValue();
            Long winningCount = winningInfo.get((long) prizeMatchingCount);

            if (winningCount != null) {
                displayBonusNumber(prizeMatchingCount, prizeAmount, winningCount);
            }
        }
    }

    public void displayBonusNumber(int prizeMatchingCount, String prizeAmount , Long winningCount){
            if(prizeMatchingCount != 7){
                System.out.println(prizeMatchingCount + "개 일치" + "(" + prizeAmount + "원) - " + winningCount + "개");
            }
            else {
                System.out.println("5개 일치 보너스 번호 일치 (" + prizeAmount + "원) - " + winningCount + "개");
            }
    }

}

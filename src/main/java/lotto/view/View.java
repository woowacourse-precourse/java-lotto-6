package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Calculator;
import lotto.domain.Prize;
import lotto.model.MatchingCounts;

public class View {
    public View() {
    }

    public String input() {
        return Console.readLine();
    }

    public void displayPurchaseQuantityMessage(int purchaseAmount) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
    }

    public void displayLottoNumbers(List<List<Integer>> numbers) {
        for (Object number : numbers) {
            System.out.println(number);
        }
    }

    public void processErrorResult() {
        System.out.println("[ERROR] 잘못 입력하셨습니다. 다시 입력해주세요.");
    }

    public void displayWinningStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printMatchingCounts(MatchingCounts matchingCounts) {
        Prize[] prizes = {
                Prize.MATCH_3,
                Prize.MATCH_4,
                Prize.MATCH_5,
                Prize.MATCH_5_PLUS_BONUS,
                Prize.MATCH_6
        };

        for (int i = 0; i < 5; i++) {
            System.out.println(prizes[i].getDescription() + " - " + matchingCounts.getMatchingCount().get(i) + "개");
        }
    }

    public void displayProfitPercent(Calculator calculator, MatchingCounts matchingCounts) {
        System.out.println("총 수익률은 " + calculator.calculateProfitPercentage(matchingCounts) + "%입니다.");
    }
}
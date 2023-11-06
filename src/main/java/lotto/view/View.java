package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.MatchingCounts;

public class View {
    public View() {
    }

    public void inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public String input() {
        return Console.readLine();
    }

    public void displayPurchaseQuantityMessage(int purchaseAmount) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
    }

    public void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printMatchingCounts(MatchingCounts matchingCounts) {
        String[] prizeDescriptions = {
                "없음", "없음", "3개 일치 (5,000원)", "4개 일치 (50,000원)",
                "5개 일치 (1,500,000원)", "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"
        };

        for (int i = 2; i <= 6; i++) {
            System.out.println(prizeDescriptions[i] + " - " + matchingCounts.getMatchingCount().get(i) + "개");
        }
    }
}

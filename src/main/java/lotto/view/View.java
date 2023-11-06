package lotto.view;

import camp.nextstep.edu.missionutils.Console;

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
}

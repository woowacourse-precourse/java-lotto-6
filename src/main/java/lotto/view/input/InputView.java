package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String enterPaymentAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String enterWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public int enterBonusWinningNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}

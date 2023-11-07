package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    // TODO : 사용자의 입력에 대한 처리

    public void askPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        Console.readLine();
    }

    public void askWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Console.readLine();
    }

    public void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Console.readLine();
    }
}

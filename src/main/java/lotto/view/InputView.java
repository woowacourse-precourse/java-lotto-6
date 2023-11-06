package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String requestPrice() {
        System.out.println("구입 금액을 입력해주세요.");
        return Console.readLine();
    }

    public String requestWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해주세요.");
        return Console.readLine();
    }

    public int requestBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }
}

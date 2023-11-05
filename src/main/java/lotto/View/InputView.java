package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String BuyLotto() {
        System.out.println("구매 금액을 입력하세요");
        return Console.readLine();
    }
    public static String RightNumber() {
        System.out.println("당첨번호를 입력해주세요.");
        return Console.readLine();
    }

    public static String BonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Console.readLine();
    }
}

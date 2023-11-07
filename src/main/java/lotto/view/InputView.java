package lotto.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public static String InputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String InputNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static Integer InputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.valueOf(Console.readLine());
    }
}

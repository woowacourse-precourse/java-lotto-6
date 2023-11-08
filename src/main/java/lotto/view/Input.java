package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String readReceivedAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String readPickedNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
        return Console.readLine();
    }
}

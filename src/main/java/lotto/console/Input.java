package lotto.console;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String askMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String askWinningNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String askBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}

package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Inputs {
    public static String getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return input;
    }

    public static String getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return input;
    }

    public static String getBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return input;
    }
}

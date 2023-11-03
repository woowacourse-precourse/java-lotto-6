package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static String readPurchaseAmount() {
        String input = Console.readLine();
        System.out.println();

        return input;
    }

    public static void promptWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static String readWinningNumbers() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static void promptBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static String readBonusNumber() {
        String bonusNumber = Console.readLine();
        System.out.println();
        return bonusNumber;
    }
}

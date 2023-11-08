package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String DELIMITER = ",";

    public static String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().replaceAll(DELIMITER," ");
    }

    public static String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}

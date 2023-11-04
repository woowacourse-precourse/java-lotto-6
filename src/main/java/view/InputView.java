package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ENTER_PRICE = "구입금액을 입력해 주세요.";
    private static String ENTER_WINNGING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static String ENTER_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";

    public static String enterPrice() {
        System.out.println(ENTER_PRICE);
        return readLine();
    }

    public static String enterWinningNumbers() {
        System.out.println(ENTER_WINNGING_NUMBERS);
        return readLine();
    }

    public static String enterBonusNumbers() {
        System.out.println(ENTER_BONUS_NUMBERS);
        return readLine();
    }
}

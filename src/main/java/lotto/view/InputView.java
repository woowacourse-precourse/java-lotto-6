package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String MONEY_REQUEST = "구입 금액을 입력해 주세요.";
    private static final String NUMBERS_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";

    public static String money() {
        System.out.println(MONEY_REQUEST);
        return readLine();
    }

    public static String lottoNumbers() {
        System.out.println();
        System.out.println(NUMBERS_REQUEST);
        return readLine();
    }

    public static String bonusNumbers() {
        System.out.println();
        System.out.println(BONUS_NUMBER_REQUEST);
        return readLine();
    }
}

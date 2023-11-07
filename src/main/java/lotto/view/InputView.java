package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputPlayPay() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }

    public static String inputLottoNumber() {
        System.out.println(INPUT_LOTTO_WINNING);
        return Console.readLine();
    }

    public static String getInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
    public static String getInputAgain() {
        return Console.readLine();

    }


}

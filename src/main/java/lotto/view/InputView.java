package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LOTTO_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int printLottoAmount() {
        System.out.println(LOTTO_AMOUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public static String inputLottoNumber() {
        System.out.println();
        System.out.println(LOTTO_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

}



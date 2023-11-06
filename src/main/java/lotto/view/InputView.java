package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_PRICE = "구입금액을 입력해 주세요.";

    public static String inputPlayerLottoPrice() {
        System.out.println(INPUT_LOTTO_PRICE);
        return Console.readLine();
    }
}

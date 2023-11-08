package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_PRICE = "구입 금액을 입력해주세요.";
    private static final String REQUEST_WINNING_NUMBERS = "\n당첨 번호를 입력해주세요.";
    private static final String REQUEST_BONUS_NUMBER = "\n보너스 번호를 입력해주세요.";

    public String requestPrice() {
        System.out.println(REQUEST_PRICE);
        return Console.readLine();
    }

    public String requestWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBERS);
        return Console.readLine();
    }

    public String requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}

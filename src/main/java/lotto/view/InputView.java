package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBERS_REQUEST_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public String getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public String getWinNumbers() {
        System.out.println(WIN_NUMBERS_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public String getBonus() {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
        return Console.readLine();
    }
}
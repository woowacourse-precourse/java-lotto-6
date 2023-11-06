package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자를 입력해야 합니다.";

    public LottoView() {}

    public int inputMoney() {
        int money;
        System.out.println(PURCHASE_AMOUNT);

        while(true) {
            try {
                money = Integer.parseInt(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(NOT_NUMBER_ERROR_MESSAGE);
            }
        }

        return money;
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputBuyLotto {
    private static final String BUY_MESSAGE = "구입금액을 입력해 주세요.";

    public int getTicket() {
        System.out.println(BUY_MESSAGE);
        String money = Console.readLine();
        System.out.println();
        validate(money);
        return Integer.parseInt(money);
    }

    private void validate(String money) {
        try {
            int number = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

}

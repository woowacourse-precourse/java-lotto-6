package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class BillAcceptor {

    private static final String REQUEST_ACCEPT_BILL_MESSAGE = "구입금액을 입력해 주세요.";

    public static int acceptBill() {
        System.out.println(REQUEST_ACCEPT_BILL_MESSAGE);
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
    }
}

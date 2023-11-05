package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.\n";

    public int readPurchaseAmount() {
        print(REQUEST_PURCHASE_AMOUNT_MESSAGE);
        return readInt();
    }

    private int readInt() {
        try {
            return Integer.parseInt(read());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("int 형식의 숫자를 입력해야 합니다");
        }
    }

    private String read() {
        return Console.readLine();
    }

    private void print(String message) {
        System.out.print(message);
    }
}

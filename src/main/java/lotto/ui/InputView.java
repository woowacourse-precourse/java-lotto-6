package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public final class InputView extends ConsoleWriter {
    public int readPaymentPrice() {
        this.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
}

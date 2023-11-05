package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int getAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }
}

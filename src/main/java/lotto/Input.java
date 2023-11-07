package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int getPrice() {
        int purchase = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                purchase = Integer.parseInt(Console.readLine());
                validInput = true;
            } catch (NumberFormatException e) {
                new IllegalArgumentExceptionHandler("구입 금액은 정수만 가능합니다.");
            }
        }

        return purchase;
    }
}

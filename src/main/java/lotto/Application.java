package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.ErrorCode.PURCHASE_AMOUNT_ERROR;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입 금액을 입력해 주세요.");
        int tryTime = 0;
        while (tryTime == 0) {
            try {
                tryTime = purchase();
            } catch (RuntimeException e) {
                handleException(e);
            }
        }
    }

    private static void handleException(RuntimeException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    private static int purchase() throws IllegalArgumentException {
        int input = Integer.parseInt(Console.readLine());
        if (input % 1000 != 0)
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR.getMessage());
        return input / 1000;
    }
}

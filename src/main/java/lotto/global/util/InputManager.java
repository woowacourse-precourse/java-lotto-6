package lotto.global.util;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.global.enums.GuideMessage.INPUT_PAYMENT_COMMAND;

public final class InputManager {

    public static int inputPayment() {
        System.out.println(INPUT_PAYMENT_COMMAND);

        while (true) {
            try {
                String payment = readLine();
                return validatePayment(payment);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());  // TODO 예외 메시지 출력 부분 삭제
            }
        }
    }

    public static int validatePayment(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어 있습니다.");
        }

        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 형식은 입력할 수 없습니다.");
        }

        if (result % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 나누어 떨어져야 합니다.");
        }

        return result;
    }
}

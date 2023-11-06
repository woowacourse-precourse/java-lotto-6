package lotto.global.util;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.global.enums.GuideMessage.INPUT_PAYMENT_COMMAND;
import static lotto.global.enums.GuideMessage.INPUT_WINNING_NUMBER_COMMAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputManager {

    public static int inputPayment() {
        System.out.println(INPUT_PAYMENT_COMMAND);

        while (true) {
            try {
                String payment = readLine().trim();
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

    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_COMMAND);

        while (true) {
            try {
                String winningNum = readLine();
                return validateWinningNumber(winningNum);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());  // TODO 예외 메시지 출력 부분 삭제
            }
        }
    }

    private static List<Integer> validateWinningNumber(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어 있습니다.");
        }

        String[] splitNums = input.trim().split(",\\s*");
        return Arrays.stream(splitNums)
                .map(num -> {
                    try {
                        return Integer.parseInt(num);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("숫자 이외의 형식은 입력할 수 없습니다.");
                    }
                })
                .toList();
    }
}

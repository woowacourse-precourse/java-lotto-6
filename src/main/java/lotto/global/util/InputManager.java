package lotto.global.util;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.global.enums.GuideMessage.INPUT_BONUS_NUMBER_COMMAND;
import static lotto.global.enums.GuideMessage.INPUT_PAYMENT_COMMAND;
import static lotto.global.enums.GuideMessage.INPUT_WINNING_NUMBER_COMMAND;

import java.util.Arrays;
import java.util.List;

public final class InputManager {

    public static int inputPayment() {

        while (true) {
            try {
                System.out.println(INPUT_PAYMENT_COMMAND);
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

        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBER_COMMAND);
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

    public static int inputBonusNumber(List<Integer> winNum) {

        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER_COMMAND);
                String bonusNum = readLine().trim();
                return validateBonusNumber(bonusNum, winNum);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());  // TODO 예외 메시지 출력 부분 삭제
            }
        }
    }

    public static int validateBonusNumber(String input, List<Integer> winNum) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어 있습니다.");
        }

        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 형식은 입력할 수 없습니다.");
        }

        if (result < 1 || result > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 범위 내의 숫자입니다.");
        }

        if (winNum.contains(result)) {
            throw new IllegalArgumentException("보너스 번호는 기존의 당첨 번호에 없는 숫자만 가능합니다.");
        }

        return result;
    }
}

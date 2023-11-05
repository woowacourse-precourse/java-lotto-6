package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = Console.readLine();
        validateInteger(moneyInput);
        return Integer.parseInt(moneyInput);
    }

    private static void validateInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }
    }
}
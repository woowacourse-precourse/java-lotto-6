package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public UserInput() {
    }

    public String input() {
        String input = Console.readLine();
        try {
            checkInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }

    public int getUserPurchaseAmount(String inputPurchaseAmount) {
        return 0;
    }

    public int getUserWinningNumbers(String inputWinningNumbers) {
        return 0;
    }

    public int getUserBonusNumber() {
        return 0;
    }

    public void checkInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumber {

    protected int bonusNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                return parseAndValidate(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAndValidate(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 유효하지 않은 숫자 형식입니다.");
        }

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
        return number;
    }
}

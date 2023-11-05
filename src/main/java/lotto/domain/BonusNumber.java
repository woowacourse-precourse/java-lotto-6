package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumber {
    static public int bonus() {
        while (true) {
            try {
                String input = Console.readLine();
                ErrorInput errorInput = new ErrorInput();
                errorInput.bonus_range(Integer.parseInt(input));
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
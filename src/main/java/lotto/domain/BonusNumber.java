package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BonusNumber {
    static public int bonus(List<Integer> win) {
        while (true) {
            try {
                String input = Console.readLine();
                ErrorInput errorInput = new ErrorInput();
                errorInput.range(input);
                errorInput.bonus_range(Integer.parseInt(input), win);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
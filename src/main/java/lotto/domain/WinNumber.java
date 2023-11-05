package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class WinNumber {
    static public List<Integer> win() {
        while (true) {
            try {
                String input = Console.readLine();
                String[] number = input.split(",");
                ErrorInput errorInput = new ErrorInput();
                List<Integer> winnum = errorInput.win_range(number);
                return winnum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
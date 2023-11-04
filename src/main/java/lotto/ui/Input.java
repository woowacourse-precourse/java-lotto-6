package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public int getUserMoney() {
        try {
            int money = Integer.parseInt(Console.readLine());
            return money;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public List<Integer> getWinningLottoNumber() {
        List<Integer> winningNumber = new ArrayList<>();
        try {
            String input = Console.readLine();
            String[] numbers = input.split(",");
            for (int i = 0; i < numbers.length; i++) {
                winningNumber.add(Integer.parseInt(numbers[i]));
            }
            return winningNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getBonusNumber() {
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}

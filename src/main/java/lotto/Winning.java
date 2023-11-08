package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Winning {
    public List<Integer> winningNum(List<Integer> numbers, int bonus) {
        while (true) {
            try {
                numbers.clear();
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String a = Console.readLine();
                String[] winningNumbers = a.split(",");

                for (int i = 0; i < winningNumbers.length; i++) {
                    numbers.add(Integer.parseInt(winningNumbers[i]));
                }
                Lotto lotto = new Lotto(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int bonusNum(List<Integer> numbers, int bonus) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                bonus = Integer.parseInt(Console.readLine());
                Lotto lotto2 = new Lotto(numbers);
                lotto2.bonusNum(bonus);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

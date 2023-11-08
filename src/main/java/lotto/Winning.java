package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Winning {
    List<Integer> numbers;
    int bonus;

    public Winning(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public List<Integer> winningNum() {
        while (true) {
            try {
                numbers.clear();
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String a = Console.readLine();
                String[] winningNumbers = a.split(",");

                setWinningNumbers(winningNumbers);
                Lotto lotto = new Lotto(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setWinningNumbers(String[] winningNumbers) {
        for (int i = 0; i < winningNumbers.length; i++) {
            numbers.add(Integer.parseInt(winningNumbers[i]));
        }
    }

    public int bonusNum() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                bonus = Integer.parseInt(Console.readLine());
                Lotto lotto2 = new Lotto(numbers);
                lotto2.duplicatedBonusNum(bonus);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

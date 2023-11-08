package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    private String getInput() {
        String input = Console.readLine();
        return input;
    }

    public int getMoneyInput() {
        String input = getInput();
        try {
            int money = Integer.parseInt(input);
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("1,000원 단위로 입력하세요.");
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }

    }


    public List<Integer> getWinnerNumbers() {
        String input = getInput();
        List<Integer> numbers = new ArrayList<>();
        try {
            String[] nums = input.split(",");
            if (nums.length == 0) {
                throw new IllegalArgumentException("쉼표로 구분된 숫자를 입력하세요.");
            }
            for (String num : nums) {
                int number = Integer.parseInt(num.trim());
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("숫자는 1이상45이하 이여야 합니다.");
                }
                numbers.add(number);
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

    public Integer getBonusNumber() {
        String input = getInput();
        try {
            Integer bonusNumber = Integer.parseInt(input);
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("숫자는 1이상45이하 이여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

}





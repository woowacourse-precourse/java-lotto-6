package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputManager {

    public long getMoney() {
        String input = Console.readLine();
        try {
            int money = Integer.parseInt(input);
            moneyValidate(input);
            return money;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 해 주세요.");
            getMoney();
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getMoney();
            return 0;
        }
    }

    public List<Integer> getCorrectNumbers() {
        String input = Console.readLine();
        try {
            List<Integer> correctNumbers = inputToList(input);
            sizeValidate(correctNumbers);
            return correctNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCorrectNumbers();
        }
    }

    public List<Integer> inputToList(String input) {
        List<Integer> correctNumbers = new ArrayList<>();
        if (!input.matches("[\\d,]+$")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식입니다.");
        }
        
        for (String s : input.split(",")) {
            int number = Integer.parseInt(s);
            numberRangeValidate(s);
            duplicateValidate(correctNumbers, number);
            correctNumbers.add(number);
        }
        return correctNumbers;
    }

    public int getBonus() {
        String input = Console.readLine();
        int bonus = 0;
        try {
            bonus = Integer.parseInt(input);
            numberRangeValidate(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 해 주세요.");
            getBonus();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getBonus();
        }
        return bonus;
    }

    public void moneyValidate(String input) {
        int money = Integer.parseInt(input);
        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매 할 수 있습니다.");
        }
    }

    public void numberRangeValidate(String input) {
        int number = Integer.parseInt(input);
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45까지의 숫자만 가능합니다.");
        }
    }

    public void duplicateValidate(List<Integer> balls, int number) {
        if (balls.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 된 번호가 존재 할 수 없습니다.");
        }
    }

    public void sizeValidate(List<Integer> balls) {
        if (balls.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}

package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public final static int LOTTO_PRICE = 1000;

    public void validateMoney(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0원 보다 커야 합니다.");
        }
    }

    public int money() {
        try {
            String input = Console.readLine();
            validateMoney(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return money();
        }
    }

    public void validateNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public Lotto winningNumbers() {
        try {
            String input = Console.readLine();
            String[] temp = input.split(",");
            List<Integer> numbers = new ArrayList<>();
            for (String item : temp) {
                validateNumber(item);
                numbers.add(Integer.parseInt(item));
            }
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winningNumbers();
        }
    }

    public int bonusNumber() {
        try {
            String input = Console.readLine();
            validateNumber(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return bonusNumber();
        }
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void inputMoney() {

        boolean validInput = false;
        System.out.println("구입금액을 입력해 주세요.");
        while (!validInput) {
            try {
                String input = Console.readLine();
                validateMoney(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1000원 단위로 입력해주세요.");
                System.out.println("구입금액을 입력해 주세요.");
            }
        }
    }

    public static void validateMoney(String input) {
        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

}

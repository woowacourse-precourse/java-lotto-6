package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println("\n구입금액을 입력해 주세요.");
        int input = 0;

        try {
            input = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }

        return input;
    }

    public static List<Integer> getLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        String input = Console.readLine();
        return changeStringToLotto(input);
    }

    public static List<Integer> changeStringToLotto(String input) {
        List<String> splitedInput = Arrays.asList(input.split(","));
        splitedInput.replaceAll(String::trim);

        List<Integer> inputNumbers = new ArrayList<>();
        for (String inputNumber : splitedInput) {
            try {
                int number = Integer.parseInt(inputNumber);
                inputNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }
        }
        return inputNumbers;
    }

    public static int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int input = 0;

        try {
            input = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        return input;
    }
}

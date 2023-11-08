package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import static lotto.util.GameMessage.*;

public class InputView {

    public static int getAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE.getMessage());
        String input;

        while (true) {
            try {
                input = validateStringInput(Console.readLine());
                validateAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 금액에는 문자를 입력하실 수 없습니다.");
            }
        }

        return Integer.parseInt(input);
    }

    public static List<Integer> getLuckyNumber() {
        System.out.println(INPUT_LUCKY_NUMBER_MESSAGE.getMessage());
        String[] inputNumbers = Console.readLine().split(",");
        List<Integer> winningNumber = new ArrayList<>();

        for (String number : inputNumbers) {
            winningNumber.add(Integer.parseInt(number));
        }

        return winningNumber;
    }

    public static int getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.getMessage());

        return Integer.parseInt(Console.readLine());
    }

    private static String validateStringInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    private static void validateAmount(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static List<Integer> getWinningNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                return convertStringToList(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static List<Integer> convertStringToList(String input) {
        String[] splitValues = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String value : splitValues) {
            String trimmedValue = value.trim();
            int number = Integer.parseInt(trimmedValue);
            numbers.add(number);
        }
        return numbers;
    }
}

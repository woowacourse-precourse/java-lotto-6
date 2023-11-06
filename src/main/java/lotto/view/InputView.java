package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static int getMoney() {
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
                System.out.println();
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
        return Arrays.stream(splitValues)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public static int getBonusNumber() {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }
}

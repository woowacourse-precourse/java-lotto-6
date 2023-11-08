package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return parseNumbers(input);
    }

    public static int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    private static List<Integer> parseNumbers(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }
}

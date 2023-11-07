package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구매 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
            scanner.next(); // 잘못된 입력을 무시합니다.
        }
        return scanner.nextInt();
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호 6개를 입력해주세요.");
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String part : parts) {
            winningNumbers.add(Integer.parseInt(part));
        }
        return winningNumbers;
    }

    public static int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해주세요.");
        return scanner.nextInt();
    }
}


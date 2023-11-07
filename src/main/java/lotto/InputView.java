package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구매 금액을 입력해주세요.");
        while (true) {
            try {
                int amount = scanner.nextInt();
                scanner.nextLine();
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 입력 금액은 1,000원 단위여야 합니다.");
                }
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
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


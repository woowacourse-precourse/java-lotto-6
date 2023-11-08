package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static int inputMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요. (1000원 단위)");
                String input = scanner.nextLine();
                int purchaseAmount = Integer.parseInt(input);
                if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다.");
                }
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

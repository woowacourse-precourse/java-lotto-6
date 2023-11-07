package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int amount = scanner.nextInt();
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다.");
        }
        return amount;
    }

    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        return scanner.next();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return scanner.nextInt();
    }
}


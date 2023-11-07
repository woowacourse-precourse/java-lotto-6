package lotto.view;

import lotto.Lotto;

import java.util.List;
import java.util.Scanner;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return scanner.nextInt();
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


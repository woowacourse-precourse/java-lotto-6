package lotto.view;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        int purchaseAmount;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요.");
                }
                purchaseAmount = Integer.parseInt(input);
                if (purchaseAmount <= 0) {
                    throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요.");
                }
                break; // 입력이 유효하면 루프를 종료합니다.
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }



    public static Lotto inputWinningLotto() {
        System.out.println("당첨 번호를 입력하세요 (1부터 45까지 중복 없이 입력): ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < Lotto.NUMBER_COUNT; i++) {
            while (true) {
                try {
                    int number = Integer.parseInt(scanner.nextLine());
                    if (number < 1 || number > 45 || numbers.contains(number)) {
                        System.out.println("[ERROR] 유효한 번호를 입력해 주세요.");
                    } else {
                        numbers.add(number);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
                }
            }
        }
        return new Lotto(numbers);
    }

    public static int inputBonusBall() {
        while (true) {
            try {
                System.out.println("보너스 볼을 입력하세요: ");
                int bonusBall = Integer.parseInt(scanner.nextLine());
                if (bonusBall < 1 || bonusBall > 45) {
                    System.out.println("[ERROR] 유효한 번호를 입력해 주세요.");
                } else {
                    return bonusBall;
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            }
        }
    }
}

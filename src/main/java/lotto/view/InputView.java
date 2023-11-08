package lotto.view;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Lotto inputWinningLotto() {
        System.out.println("당첨 번호를 입력하세요 (1부터 45까지 중복 없이 입력): ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < Lotto.NUMBER_COUNT; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            numbers.add(number);
        }
        return new Lotto(numbers);
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력하세요: ");
        return Integer.parseInt(scanner.nextLine());
    }
}

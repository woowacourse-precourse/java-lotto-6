package lotto.view;

import java.util.Scanner;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static List<Integer> inputWinningNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] numbers = scanner.nextLine().split(",");
                if (numbers.length != LOTTO_NUMBERS_SIZE) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
                }
                List<Integer> winningNumbers = Stream.of(numbers)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                if (winningNumbers.stream().anyMatch(number -> number < 1 || number > MAX_LOTTO_NUMBER)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if (winningNumbers.size() != new HashSet<>(winningNumbers).size()) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
                }
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

   
}

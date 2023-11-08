package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = getInputAmount();
            LottoGame game = new LottoGame(purchaseAmount);
            game.printLottos();

            List<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();

            game.checkResults(winningNumbers, bonusNumber);
            System.out.printf("총 수익률은 %.1f%%입니다.", game.calculateProfit());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getInputAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0 || amount % LottoGame.PRICE_PER_LOTTO != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private static List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요. (숫자 6개를 콤마로 구분)");
            String input = Console.readLine();
            try {
                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .distinct() // 중복 제거
                        .collect(Collectors.toList());

                if (numbers.size() != 6 || numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 없이 6개여야 하며, 1부터 45 사이의 숫자여야 합니다.");
                }
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
        }
    }

    private static int getBonusNumber() {
        while (true) {
            System.out.println("보너스 볼을 입력해 주세요.");
            String input = Console.readLine();
            try {
                int bonusNumber = Integer.parseInt(input);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 볼은 숫자여야 합니다.");
            }
        }
    }
}

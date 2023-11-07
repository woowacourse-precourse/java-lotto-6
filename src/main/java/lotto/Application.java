package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int count = purchaseAmount / 1000;
        System.out.println(count + "개를 구매했습니다.");
        LottoMachine machine = new LottoMachine();
        machine.issue(count);
        machine.printIssuedLottos();
        List<Integer> winningNumbers = getWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonusNumber = getBonusNumber();
        WinningResult result = machine.checkWinning(winningLotto, bonusNumber);
        result.printWinningResult();
        System.out.printf("총 수익률은 %.1f%%입니다. ", result.calculateEarningsRate(purchaseAmount));
    }

    private static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력하세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine());
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("로또 구입 금액은 0보다 커야 합니다.");
        }
    }

    private static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
                validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        if (winningNumbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("당첨 번호는 1~45 사이의 숫자여야 합니다.");
        }
        long distinctCount = winningNumbers.stream().distinct().count();
        if (distinctCount != 6) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않아야 합니다.");
        }
    }

    private static int getBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}

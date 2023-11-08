package lotto;

import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = generateLottos(purchaseAmount);

        int lottoCount = lottos.size();
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        Lotto winningLotto = new Lotto(winningNumbers);

        int totalPrize = calculateTotalPrize(lottos, winningLotto, bonusNumber);
        int totalSpent = purchaseAmount;
        double profitability = (double) totalPrize / totalSpent * 100;

        printResults(lottoCount, totalPrize, profitability);
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountString = Console.readLine();
        return Integer.parseInt(purchaseAmountString);
    }

    private static List<Lotto> generateLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
        return lottos;
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersString = Console.readLine();
        return parseNumbers(winningNumbersString);
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberString = Console.readLine();
        return Integer.parseInt(bonusNumberString);
    }

    private static int calculateTotalPrize(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        int totalPrize = 0;
        for (Lotto lotto : lottos) {
            int matchingNumbers = winningLotto.match(lotto);
            totalPrize += calculatePrize(matchingNumbers, lotto.getNumbers().contains(bonusNumber));
        }
        return totalPrize;
    }

    private static int calculatePrize(int matchingNumbers, boolean bonusMatch) {
        if (matchingNumbers == 6) {
            return 2_000_000_000;
        } else if (matchingNumbers == 5 && bonusMatch) {
            return 30_000_000;
        } else if (matchingNumbers == 5) {
            return 1_500_000;
        } else if (matchingNumbers == 4) {
            return 50_000;
        } else if (matchingNumbers == 3) {
            return 5_000;
        } else {
            return 0;
        }
    }

    private static void printResults(int lottoCount, int totalPrize, double profitability) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoCount + "개");
        System.out.println("4개 일치 (50,000원) - 0개");
        System.out.println("5개 일치 (1,500,000원) - 0개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        System.out.println("6개 일치 (2,000,000,000원) - 0개");
        System.out.println("\n총 수익률은 " + profitability + "%입니다.");
    }

    private static List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            numbers = List.of(input.split(",")).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            new Lotto(numbers); // Lotto 클래스의 validate를 사용하여 유효성 검사
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println("당첨 번호를 다시 입력해 주세요.");
            String newInput = Console.readLine();
            return parseNumbers(newInput);
        }

        return numbers;
    }

    private static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberString = Console.readLine();
        try {
            int bonusNumber = Integer.parseInt(bonusNumberString);
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("보너스 번호는 1부터 45까지의 수여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            return readBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return readBonusNumber();
        }
    }
}


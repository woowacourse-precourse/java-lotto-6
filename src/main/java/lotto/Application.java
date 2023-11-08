package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.Collectors;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = readPurchaseAmount();
        List<Lotto> lottos = generateLottos(purchaseAmount);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = readNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = readBonusNumber();

        printLottos(lottos);
        WinningResult winningResult = calculateWinningResult(lottos, winningNumbers, bonusNumber);
        printWinningResult(winningResult);
    }

    private static int readPurchaseAmount() {
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = Integer.parseInt(Console.readLine());
                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
                }
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> readNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (true) {
            try {
                String input = Console.readLine();
                numbers = Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                validateNumbers(numbers);
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readBonusNumber() {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = Integer.parseInt(Console.readLine());
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println("\n구입한 로또 번호");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private static WinningResult calculateWinningResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            int matchedNumbers = countMatchedNumbers(lotto, winningNumbers);
            boolean hasBonusMatch = lotto.getNumbers().contains(bonusNumber);
            winningResult.updateResult(matchedNumbers, hasBonusMatch);
        }
        return winningResult;
    }

    private static int countMatchedNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static void printWinningResult(WinningResult winningResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        winningResult.printResult();
        double totalProfitRate = winningResult.calculateTotalProfitRate();
        System.out.printf("총 수익률은 %.1f%%입니다.\n", totalProfitRate);
    }
}

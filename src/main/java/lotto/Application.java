package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int purchaseAmount = getPurchaseAmount(scanner);
        List<Integer> userNumbers = getUserNumbers(scanner);
        int bonusNumber = getBonusNumber(scanner);

        List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);

        displayPurchasedLottos(purchasedLottos);
        List<Integer> winningNumbers = getWinningNumbers(scanner);
        List<Integer> matchedLottoCounts = countMatchedLottos(purchasedLottos, winningNumbers, bonusNumber);

        displayWinningResult(matchedLottoCounts);
    }

    private static int getPurchaseAmount(Scanner scanner) {
        System.out.print("구입금액을 입력해 주세요: ");
        int purchaseAmount = scanner.nextInt();
        if (purchaseAmount % 1000 != 0 || purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return purchaseAmount;
    }

    private static List<Integer> getUserNumbers(Scanner scanner) {
        System.out.print("구매할 로또 번호를 입력하세요 (1~45 사이의 숫자 6개, 쉼표(,)로 구분): ");
        String userNumbersInput = scanner.next();
        List<Integer> userNumbers = parseUserNumbers(userNumbersInput);
        return userNumbers;
    }

    private static int getBonusNumber(Scanner scanner) {
        System.out.print("보너스 번호를 입력해 주세요: ");
        return scanner.nextInt();
    }

    private static List<Integer> getWinningNumbers(Scanner scanner) {
        System.out.print("당첨 번호를 입력해 주세요 (1~45 사이의 숫자 6개, 쉼표(,)로 구분): ");
        String winningNumbersInput = scanner.next();
        List<Integer> winningNumbers = parseUserNumbers(winningNumbersInput);
        return winningNumbers;
    }

    private static List<Integer> parseUserNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> userNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            userNumbers.add(number);
        }
        if (userNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        return userNumbers;
    }

    // Random 클래스를 사용하여 난수 생성
    private static List<Lotto> purchaseLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> purchasedLottos = new ArrayList<>();
        Random random = new Random(); // Random 객체 생성
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 6) {
                int number = random.nextInt(45) + 1;
                if (!numbers.contains(number)) {
                    numbers.add(number);
                }
            }
            Lotto lotto = new Lotto(numbers);
            purchasedLottos.add(lotto);
        }
        return purchasedLottos;
    }

    private static void displayPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer> countMatchedLottos(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> matchedLottoCounts = new ArrayList<>();
        for (Lotto lotto : purchasedLottos) {
            int count = countMatchedNumbers(lotto.getNumbers(), winningNumbers);
            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);
            if (count == 5 && hasBonusNumber) {
                count = 5; // 5개 일치, 보너스 볼 일치
            }
            matchedLottoCounts.add(count);
        }
        return matchedLottoCounts;
    }

    private static int countMatchedNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static void displayWinningResult(List<Integer> matchedLottoCounts) {
        int[] result = new int[6];
        for (int count : matchedLottoCounts) {
            result[count]++;
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 3; i <= 5; i++) {
            int prize = calculatePrize(i);
            int count = result[i];
            System.out.println(i + "개 일치 (" + prize + "원) - " + count + "개");
        }
        int count = result[5];
        int bonusCount = result[5] - result[4];
        int bonusPrize = calculatePrize(5);
        System.out.println("5개 일치, 보너스 볼 일치 (" + bonusPrize + "원) - " + bonusCount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[6] + "개");

        double totalPrize = calculateTotalPrize(result);
        double totalPurchase = matchedLottoCounts.size() * 1000.0;
        double earningRate = (totalPrize / totalPurchase) * 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningRate);
    }

    private static int calculatePrize(int matchedCount) {
        int[] prizeTable = {0, 0, 0, 5_000, 50_000, 1_500_000, 2_000_000_000};
        return prizeTable[matchedCount];
    }

    private static double calculateTotalPrize(int[] result) {
        double totalPrize = 0;
        for (int i = 3; i <= 6; i++) {
            totalPrize += result[i] * calculatePrize(i);
        }
        return totalPrize;
    }
}

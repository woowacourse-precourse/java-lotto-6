package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBERS = 6;

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = generateLottos(numberOfLottos);

        int[][] winningNumbers = getWinningNumbers();
        int[] winningLotto = winningNumbers[0];
        int bonusBall = winningNumbers[1][0];

        System.out.println("당첨 번호: " + Arrays.toString(winningLotto));
        System.out.println("보너스 번호: " + bonusBall);

        int[] matchCounts = countMatches(lottos, winningLotto, bonusBall);
        int a = countMatchesWithPrize(matchCounts, 3, 5000);
        int b = countMatchesWithPrize(matchCounts, 4, 50000);
        int c = countMatchesWithPrize(matchCounts, 5, 1500000);
        int d = countMatchesWithPrizeAndBonus(lottos, matchCounts, 6, 30000000, bonusBall);
        int e = countMatchesWithPrize(matchCounts, 6, 2000000000);

        double profitRate = calculateProfitRate(purchaseAmount, a, b, c, d, e);

        printLottos(lottos);
        printResult(a, b, c, d, e, profitRate);
    }

    private static int getPurchaseAmount() {
        int purchaseAmount;
        do {
            System.out.print("구입금액을 입력해 주세요. ");
            try {
                purchaseAmount = Integer.parseInt(Console.readLine());
                if (purchaseAmount < LOTTO_PRICE) {
                    throw new IllegalArgumentException("[ERROR] 최소 1,000원 이상 입력하세요.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return purchaseAmount;
    }

    private static int[][] getWinningNumbers() {
        int[][] winningNumbers = new int[2][];
        System.out.print("당첨 번호를 입력해 주세요: ");
        winningNumbers[0] = Arrays.stream(Console.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print("보너스 번호를 입력해 주세요: ");
        winningNumbers[1] = new int[]{Integer.parseInt(Console.readLine())};
        return winningNumbers;
    }

    private static List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBERS);
            // 오름차순으로 정렬
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static int[] countMatches(List<Lotto> lottos, int[] winningLotto, int bonusBall) {
        int[] matchCounts = new int[lottos.size()];
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            int matchCount = countMatchNumbers(lotto, winningLotto);
            boolean hasBonusBall = lotto.getNumbers().contains(bonusBall);
            matchCounts[i] = calculatePrize(matchCount, hasBonusBall);
        }
        return matchCounts;
    }

    private static int countMatchesWithPrize(int[] matchCounts, int matchCount, int prize) {
        return (int) Arrays.stream(matchCounts)
                .filter(count -> count == matchCount)
                .count() * prize;
    }

    private static int countMatchesWithPrizeAndBonus(List<Lotto> lottos, int[] matchCounts, int matchCount, int prize, int bonusBall) {
        return (int) IntStream.range(0, lottos.size())
                .filter(i -> matchCounts[i] == matchCount)
                .filter(i -> lottos.get(i).getNumbers().contains(bonusBall))
                .count() * prize;
    }

    private static int calculatePrize(int matchCount, boolean hasBonusBall) {
        if (matchCount == 6) {
            return hasBonusBall ? 6 : 7;
        } else if (matchCount == 5) {
            return hasBonusBall ? 5 : 4;
        } else if (matchCount == 4) {
            return hasBonusBall ? 3 : 2;
        } else if (matchCount == 3) {
            return hasBonusBall ? 1 : 0;
        } else {
            return 0; // No prize for less than 3 matches
        }
    }

    private static int countMatchNumbers(Lotto lotto, int[] winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> Arrays.stream(winningLotto).anyMatch(winningNumber -> winningNumber == number))
                .count();
    }

    private static double calculateProfitRate(int purchaseAmount, int a, int b, int c, int d, int e) {
        int totalPrize = a + b + c + d + e;
        int totalPurchaseAmount = purchaseAmount;
        int totalProfit = totalPrize - totalPurchaseAmount;
        double profitRatePercentage = ((double) totalProfit / totalPurchaseAmount) * 100;
        return profitRatePercentage;
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }


    private static void printResult(int a, int b, int c, int d, int e, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원) - " + a + "개");
        System.out.println("4개 일치 (50,000원) - " + b + "개");
        System.out.println("5개 일치 (1,500,000원) - " + c + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + d + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + e + "개");

        double totalPrize = a * 5000 + b * 50000 + c * 1500000 + d * 30000000 + e * 2000000000;
        double totalPurchaseAmount = a * LOTTO_PRICE;
        double totalProfit = totalPrize - totalPurchaseAmount;

        double profitRatePercentage = (totalProfit / totalPurchaseAmount) * 100;
        System.out.printf("총 수익률은 %.2f%%입니다.%n", profitRatePercentage);
    }
}
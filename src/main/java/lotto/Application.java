package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBERS = 6;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = generateLottos(numberOfLottos);

        Lotto winningLotto = getWinningLotto();
        int bonusBall = getBonusBall();

        int[] matchCounts = countMatches(lottos, winningLotto, bonusBall);
        int prizeMoney = calculatePrizeMoney(matchCounts);
        double profitRate = (double) prizeMoney / purchaseAmount;

        printLottos(lottos);
        printResult(matchCounts, profitRate);
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

    private static Lotto getWinningLotto() {
        System.out.print("당첨 번호를 입력해 주세요.");
        String[] winningNumbers = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : winningNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return new Lotto(numbers);
    }

    private static int getBonusBall() {
        System.out.print("보너스 번호를 입력해 주세요. ");
        return Integer.parseInt(Console.readLine());
    }

    private static List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBERS);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }


    private static int[] countMatches(List<Lotto> lottos, Lotto winningLotto, int bonusBall) {
        int[] matchCounts = new int[6];
        for (Lotto lotto : lottos) {
            int matchCount = countMatchNumbers(lotto, winningLotto);
            boolean hasBonusBall = lotto.getNumbers().contains(bonusBall);
            matchCounts[matchCount] += hasBonusBall ? 0 : 1;
        }
        return matchCounts;
    }

    private static int countMatchNumbers(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }
    private static int calculatePrizeMoney(int[] matchCounts) {
        int prizeMoney = 0;
        for (int i = 0; i < 6; i++) {
            int matchCount = matchCounts[i];
            if (i == 5) {
                prizeMoney += matchCount * 30_000_000;
            } else if (i == 6) {
                prizeMoney += matchCount * 2_000_000_000;
            } else {
                prizeMoney += matchCount * (6 - i) * 1_000;
            }
        }
        return prizeMoney;
    }

    private static void printResult(int[] matchCounts, double profitRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 3; i < 6; i++) {
            int matchCount = matchCounts[i];
            int prizeMoney = i == 5 ? 30_000_000 : i == 6 ? 2_000_000_000 : (6 - i) * 1_000;
            System.out.println(i + "개 일치 (" + prizeMoney + "원) - " + matchCount + "개");
        }
        System.out.println();
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }


}

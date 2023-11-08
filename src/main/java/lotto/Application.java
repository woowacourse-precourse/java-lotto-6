package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입 금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());

        List<Lotto> lottos = purchaseLottos(purchaseAmount);

        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = readNumbersFromConsole();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        Lotto winningLotto = new Lotto(winningNumbers);
        int countOfMatch = countOfMatch(lottos, winningLotto);
        int totalPrize = calculatePrize(countOfMatch, lottos, bonusNumber);

        printResult(countOfMatch, totalPrize);

    }

    private static List<Lotto> purchaseLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private static List<Integer> readNumbersFromConsole() {
        String input = Console.readLine();
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

    private static int countOfMatch(List<Lotto> lottos, Lotto winningLotto) {
        int count = 0;

        for (Lotto lotto : lottos) {
            count += lotto.countOfMatch(winningLotto);
        }

        return count;
    }

    private static int countMatches(List<Lotto> lottos, int countOfMatch) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.countOfMatch(winLotto) == countOfMatch)
                .count();
    }

    private static int countMatchesWithBonus(List<Lotto> lottos, int countOfMatch, int bonusNumber) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.countOfMatch(winLotto) == countOfMatch
                        && lotto.contains(bonusNumber))
                .count();
    }

    private static void printResult(int countOfMatch, int totalPrize) {
        // 결과 출력: 당첨 내역 및 수익률 출력
        System.out.println("당첨 통계");
        System.out.println("---");

        String prizeMessage = Prize.getPrizeMessage(countOfMatch);
        String prizeAmount = Prize.getPrizeAmount(countOfMatch);

        if (countOfMatch == 0) {
            System.out.println(prizeMessage);
        } else {
            System.out.println(prizeMessage + " - " + prizeAmount + " - " + countOfMatch + "개");
        }

        System.out.printf("총 수익률은 %.2f%%입니다.\n", (totalPrize / (1000.0 * lottos.size())));
    }

    private static int calculatePrize(int countOfMatch, List<Lotto> lottos, int bonusNumber) {
        List<Prize> prizes = initializePrizes();

        int totalPrize = 0;
        for (Prize prize : prizes) {
            if (prize.getCountOfMatch() == countOfMatch) {
                if (prize.getCountOfMatch() == 5) {
                    totalPrize += calculatePrizeForFiveMatches(lottos, bonusNumber, prize);
                } else {
                    totalPrize += calculatePrizeForOtherMatches(lottos, prize);
                }
            }
        }

        return totalPrize;
    }

    private static int calculatePrizeForFiveMatches(List<Lotto> lottos, int bonusNumber, Prize prize) {
        int countWithBonus = countMatchesWithBonus(lottos, 5, bonusNumber);
        int countWithoutBonus = countMatches(lottos, 5);

        return countWithBonus * prize.getAmount() + (countWithoutBonus - countWithBonus) * prize.getAmount();
    }

    private static int calculatePrizeForOtherMatches(List<Lotto> lottos, Prize prize) {
        int count = countMatches(lottos, prize.getCountOfMatch());
        return count * prize.getAmount();
    }

    private static List<Prize> initializePrizes() {
        List<Prize> prizes = new ArrayList<>();
        prizes.add(new Prize(3, 5000));
        prizes.add(new Prize(4, 50000));
        prizes.add(new Prize(5, 1500000));
        prizes.add(new Prize(6, 2000000000));
        prizes.add(new Prize(5, 30000000)); // 5개 일치, 보너스 볼 일치
        return prizes;
    }

}

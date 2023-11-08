package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import java.text.NumberFormat;
import java.util.Locale;

public class Application {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_ONE_PRICE = 1000;


    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        int lottoCount = purchaseAmount / LOTTO_ONE_PRICE;

        List<Lotto> lottos = generateLottos(lottoCount);
        printLottos(lottos);

        Lotto winningLotto = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        System.out.println();

        Map<Rank, Integer> results = calculateResults(lottos, winningLotto, bonusNumber);
        printResults(results);
        printYield(results, purchaseAmount);
    }

    private static int inputPurchaseAmount() {
        int purchaseAmount = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(Console.readLine());
                isValidInput = checkPurchaseAmount(purchaseAmount);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            }
        }
        System.out.println();
        return purchaseAmount;
    }

    private static boolean checkPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % LOTTO_ONE_PRICE != 0) {
            System.out.println("[ERROR] 구입금액은 " + LOTTO_ONE_PRICE + "원 단위의 양수여야 합니다.");
            return false;
        }
        return true;
    }

    private static List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.println();
    }

    private static Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumberStrings = Console.readLine().split(",");
        List<Integer> winningNumbers = Arrays.stream(winningNumberStrings)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (winningNumbers.size() != 6 || new HashSet<>(winningNumbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        System.out.println();
        return new Lotto(winningNumbers);
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine().trim());
    }

    private static Map<Rank, Integer> calculateResults(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto, winningLotto);
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        return results;
    }

    private static int getMatchCount(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    private static void printResults(Map<Rank, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .sorted(Comparator.comparingInt(Rank::getPrizeMoney))
                .forEach(rank -> {
                    int count = results.getOrDefault(rank, 0);
                    String prizeMoneyFormatted = NumberFormat.getNumberInstance(Locale.KOREA).format(rank.getPrizeMoney());

                    if (rank == Rank.SECOND) {
                        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", prizeMoneyFormatted, count);
                        return;
                    }
                    System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getMatchCount(), prizeMoneyFormatted, count);
                });
    }

    private static void printYield(Map<Rank, Integer> results, int purchaseAmount) {
        long totalPrize = results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
        double yield = (double) totalPrize / purchaseAmount;
        System.out.printf("총 수익률은 %.1f%%입니다.", yield * 100);
    }
}
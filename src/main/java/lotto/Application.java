package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Application {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_TEST_PURCHASE = 10000;
    private static final Map<Integer, BiFunction<Integer, Boolean, Integer>> rankDecider = new HashMap<>();
    private static final Map<Integer, Integer> prizeMoneyMap = new HashMap<>();

    static {
        rankDecider.put(6, (matches, bonus) -> 1);
        rankDecider.put(5, Application::rankForFiveMatches);
        rankDecider.put(4, (matches, bonus) -> 4);
        rankDecider.put(3, (matches, bonus) -> 5);

        prizeMoneyMap.put(1, 2000000000);
        prizeMoneyMap.put(2, 30000000);
        prizeMoneyMap.put(3, 1500000);
        prizeMoneyMap.put(4, 50000);
        prizeMoneyMap.put(5, 5000);
    }


    public static void main(String[] args) {
        int totalSpendings = 0;
        boolean isValidPurchaseAmount = false;
        while (!isValidPurchaseAmount) {
            try {
                System.out.println("로또를 구매할 금액을 입력하세요.");
                totalSpendings = Integer.parseInt(Console.readLine().trim());

                if (totalSpendings < LOTTO_PRICE || totalSpendings % LOTTO_PRICE != 0) {
                    System.out.println("[ERROR] 로또 구매 금액은 " + LOTTO_PRICE + "원 단위로 입력해야 합니다.");
                } else {
                    isValidPurchaseAmount = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 숫자로만 구성되어야 합니다.");
            }
        }
        int numberOfPurchasedLottos = totalSpendings / LOTTO_PRICE;
        System.out.println(numberOfPurchasedLottos + "개를 구매했습니다.");

        long totalWinnings = 0;

        List<Lotto> purchasedLottos = new ArrayList<>();
        Map<Integer, Long> winningsMap = new HashMap<>();

        System.out.println(numberOfPurchasedLottos + "개를 구매했습니다.");
        for (int i = 0; i < numberOfPurchasedLottos; i++) {
            Lotto lotto = Lotto.generate();
            purchasedLottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }

        List<Integer> winningNumbers = new ArrayList<>();
        int bonusNumber = 0;
        boolean isValidWinningNumbers = false;
        boolean isValidBonusNumber = false;

        while (!isValidWinningNumbers) {
            try {
                System.out.println("당첨 번호를 쉼표로 구분하여 입력하세요.");
                String winningNumbersInput = Console.readLine();

                winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                validateWinningNumbers(winningNumbers);
                isValidWinningNumbers = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 숫자로만 구성되어야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (!isValidBonusNumber) {
            try {
                System.out.println("보너스 번호를 입력하세요.");
                bonusNumber = Integer.parseInt(Console.readLine().trim());

                validateBonusNumber(bonusNumber, winningNumbers);
                isValidBonusNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 숫자로만 구성되어야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("입력된 당첨 번호: " + winningNumbers + " + 보너스 번호: " + bonusNumber);

        for (Lotto lotto : purchasedLottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

            int rank = rankDecider.getOrDefault(matchCount, (m, b) -> 0).apply(matchCount, hasBonus);

            totalWinnings += prizeMoneyMap.getOrDefault(rank, 0);
            if (rank > 0) { // rank가 0보다 클 때만 winningsMap에 결과를 추가합니다.
                winningsMap.merge(rank, 1L, Long::sum);
            }
        }

        double earningsRate = ((double) totalWinnings / totalSpendings) * 100;
        earningsRate = Math.round(earningsRate * 100) / 100.0;


        Map<Integer, String> rankDescriptionMap = Map.of(
                1, "6개 일치 (2,000,000,000원)",
                2, "5개 일치, 보너스 볼 일치 (30,000,000원)",
                3, "5개 일치 (1,500,000원)",
                4, "4개 일치 (50,000원)",
                5, "3개 일치 (5,000원)"
        );
        // 등수별 당첨 결과 출력
        rankDescriptionMap.forEach((rank, description) -> {
            long count = winningsMap.getOrDefault(rank, 0L);
            System.out.println(description + " - " + count + "개");
        });

        System.out.println("당신의 당첨 결과입니다:");
        winningsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    if (entry.getValue() > 0) {
                        System.out.println(entry.getKey() + "등을 " + entry.getValue() + "번 당첨, 총 상금: " + (prizeMoneyMap.get(entry.getKey()) * entry.getValue()) + "원");
                    }
                });

        System.out.println("총 수익: " + totalWinnings + "원");
        System.out.println("총 수익률은 " + earningsRate + "%입니다.");
    }

    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        uniqueNumbers.retainAll(winningNumbers);
        return uniqueNumbers.size();
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (winningNumbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static int rankForFiveMatches(Integer matches, Boolean bonus) {
        if (bonus) {
            return 2;
        }
        return 3;
    }
}

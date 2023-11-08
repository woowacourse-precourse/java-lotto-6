package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoUI {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        if (purchaseAmount < LOTTO_PRICE || purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        return purchaseAmount;
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(formatLottoNumbers(lotto.getNumbers()));
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumberStrings = Console.readLine().split(",");
        return parseNumbers(winningNumberStrings);
    }

    public static int inputBonusNumbers(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
        return bonusNumber;
    }

    public static void printResults(Map<LottoRank, Integer> rankCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.printf("3개 일치 (%,d원) - %d개\n", LottoRank.FIFTH.getWinnings(), rankCounts.getOrDefault(LottoRank.FIFTH, 0));
        System.out.printf("4개 일치 (%,d원) - %d개\n", LottoRank.FOURTH.getWinnings(), rankCounts.getOrDefault(LottoRank.FOURTH, 0));
        System.out.printf("5개 일치 (%,d원) - %d개\n", LottoRank.THIRD.getWinnings(), rankCounts.getOrDefault(LottoRank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n", LottoRank.SECOND.getWinnings(), rankCounts.getOrDefault(LottoRank.SECOND, 0));
        System.out.printf("6개 일치 (%,d원) - %d개\n", LottoRank.FIRST.getWinnings(), rankCounts.getOrDefault(LottoRank.FIRST, 0));
    }

    public static void calculateEarnings(Map<LottoRank, Integer> rankCounts, int lottoCount) {
        long totalWinnings = rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getWinnings() * entry.getValue())
                .sum();

        long totalSpent = (long) lottoCount * LOTTO_PRICE;
        double earningsRate = (double) totalWinnings / totalSpent;
        double earningsRatePercentage = earningsRate * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningsRatePercentage);
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }

    private static List<Integer> parseNumbers(String[] numberStrings) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            numbers.add(number);
        }
        return numbers;
    }
}

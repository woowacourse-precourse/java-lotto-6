package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void main(String[] args) {

        int purchaseAmount = getPurchaseAmount();
        if (purchaseAmount == -1) {
            return;
        }

        List<Lotto> lottos = generateLottos(purchaseAmount);
        printPurchasedLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        if (winningNumbers.isEmpty()) {
            return;
        }

        int bonusNumber = getBonusNumber();
        int[] result = calculateResult(lottos, winningNumbers, bonusNumber);
        printResult(result);
    }

    private static int getPurchaseAmount() {
        int purchaseAmount = -1;
        while (purchaseAmount == -1) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                purchaseAmount = Integer.parseInt(Console.readLine());
                if (purchaseAmount % LOTTO_PRICE != 0) {
                    System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
                    purchaseAmount = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
            }
        }
        return purchaseAmount;
    }


    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        return parseNumbers(winningNumbersInput);
    }

    private static List<Integer> parseNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            numberString = numberString.trim();
            try {
                int number = Integer.parseInt(numberString);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
                return Collections.emptyList();
            }
        }

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            System.out.println("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
            return Collections.emptyList();
        }

        return numbers;
    }

    private static int getBonusNumber() {
        int bonusNumber = -1;
        while (bonusNumber == -1) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                bonusNumber = Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
            }
        }
        return bonusNumber;
    }

    private static List<Lotto> generateLottos(int purchaseAmount) {
        int totalLottoCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < totalLottoCount; i++) {
            lottos.add(Lotto.generate());
        }
        return lottos;
    }

    private static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static int[] calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] result = new int[6];
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean isBonusMatch = lotto.contains(bonusNumber);
            if (matchCount == 6) {
                result[0]++;
            } else if (matchCount == 5 && isBonusMatch) {
                result[1]++;
            } else if (matchCount == 5) {
                result[2]++;
            } else if (matchCount == 4) {
                result[3]++;
            } else if (matchCount == 3) {
                result[4]++;
            }
        }
        return result;
    }

    private static void printResult(int[] result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printPrize(result, 5, "3개 일치", 5_000);
        printPrize(result, 4, "4개 일치", 50_000);
        printPrize(result, 3, "5개 일치", 1_500_000);
        printPrize(result, 2, "5개 일치, 보너스 볼 일치", 30_000_000);
        printPrize(result, 1, "6개 일치", 2_000_000_000);
        printTotalProfitRate(result);
    }

    private static void printPrize(int[] result, int rank, String prize, int prizeAmount) {
        int count = result[rank - 1];
        System.out.println(prize + " (" + String.format("%,d원", prizeAmount) + ") - " + count + "개");
    }

    private static void printTotalProfitRate(int[] result) {
        double totalPrize = 0;
        for (int i = 0; i < result.length; i++) {
            totalPrize += result[i] * getPrizeAmount(i + 1);
        }
        double totalSpent = LOTTO_PRICE * result.length;
        double profitRate = ((totalPrize - totalSpent) / totalSpent) * 100.0;

        String profitRateString = String.format("총 수익률은 %.1f%%입니다.", Math.abs(profitRate));

        if (profitRate < 0) {
            profitRateString = "-" + profitRateString;
        }

        System.out.println(profitRateString);
    }




    private static int getPrizeAmount(int rank) {
        if (rank == 1) return 2_000_000_000;
        if (rank == 2) return 30_000_000;
        if (rank == 3) return 1_500_000;
        if (rank == 4) return 50_000;
        if (rank == 5) return 5_000;
        return 0;
    }

    static class Lotto {
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
            this.numbers = numbers;
        }

        public int getMatchCount(List<Integer> winningNumbers) {
            return (int) winningNumbers.stream()
                    .filter(numbers::contains)
                    .count();
        }

        public List<Integer> getNumbers() {
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            return sortedNumbers;
        }

        public boolean contains(int number) {
            return numbers.contains(number);
        }

        public static Lotto generate() {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
            return new Lotto(numbers);
        }
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottosToPurchase = purchaseAmount / LOTTO_PRICE;

        System.out.println(numberOfLottosToPurchase + "개를 구매했습니다.");

        List<Lotto> purchasedLottos = purchaseLottos(numberOfLottosToPurchase);
        printPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        int totalPrize = checkWinningLottos(purchasedLottos, winningNumbers, bonusNumber);

        double totalEarningRate = (double) totalPrize / (LOTTO_PRICE * purchasedLottos.size()) * 100;
        System.out.println("총 수익률은 " + totalEarningRate + "%입니다.");
    }

    private static int getPurchaseAmount() {
        int purchaseAmount;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(Console.readLine());
                if (purchaseAmount < LOTTO_PRICE) {
                    throw new IllegalArgumentException("[ERROR] 최소 구입금액은 1,000원입니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    private static List<Lotto> purchaseLottos(int numberOfLottosToPurchase) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottosToPurchase; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요: ");
        String winningNumberInput = Console.readLine();
        return parseNumbers(winningNumberInput);
    }

    private static int getBonusNumber() {
        int bonusNumber;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(Console.readLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private static List<Integer> parseNumbers(String input) {
        String[] numberTokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : numberTokens) {
            try {
                int number = Integer.parseInt(token.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
                System.out.println("당첨 번호를 다시 입력해 주세요: ");
                return parseNumbers(Console.readLine());
            }
        }
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 6개의 숫자를 입력해 주세요.");
            System.out.println("당첨 번호를 다시 입력해 주세요: ");
            return parseNumbers(Console.readLine());
        }
        return numbers;
    }

    private static int checkWinningLottos(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCounts = new int[6];
        int totalPrize = 0;

        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatchingNumbers(lotto, winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                System.out.println("1등 (6개 번호 일치): 2,000,000,000원");
                totalPrize += 2_000_000_000;
            } else if (matchCount == 5 && bonusMatch) {
                System.out.println("2등 (5개 번호 + 보너스 번호 일치): 30,000,000원");
                totalPrize += 30_000_000;
            } else if (matchCount == 5) {
                System.out.println("3등 (5개 번호 일치): 1,500,000원");
                totalPrize += 1_500_000;
            } else if (matchCount == 4) {
                System.out.println("4등 (4개 번호 일치): 50,000원");
                totalPrize += 50_000;
            } else if (matchCount == 3) {
                System.out.println("5등 (3개 번호 일치): 5,000원");
                totalPrize += 5_000;
            }

            if(matchCount > 2){
                matchCounts[matchCount-1]++;
            }
        }

        printWinningStatistics(matchCounts, bonusNumber);

        System.out.println(totalPrize);

        return totalPrize;
    }

    private static int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
    }

    private static void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void printWinningStatistics(int[] matchCounts, int bonusNumber) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        List<String> prizeDescriptions = Arrays.asList(
                "3개 번호 일치",
                "4개 번호 일치",
                "5개 번호 일치",
                "5개 번호 + 보너스 번호 일치",
                "6개 번호 일치"
        );

        for (int i = 0; i < matchCounts.length - 1; i++) {
            int matchCount = i + 3;
            String prize = getPrize(matchCount, bonusNumber);
            int winners = matchCounts[i];

            System.out.println(prizeDescriptions.get(i) + " (" + prize + "원) - " + winners + "개");
        }
    }

    private static String getPrize(int matchCount, int bonusNumber) {
        if (matchCount < 3) {
            return "0";
        }
        if (matchCount == 3) {
            return "5,000";
        }
        if (matchCount == 4) {
            return "50,000";
        }
        if (matchCount == 5) {
            return "1,500,000";
        }
        if (matchCount == 5 && bonusNumber == 1) {
            return "30,000,000";
        }
        if (matchCount == 6) {
            return "2,000,000,000";
        }
        return "0";
    }

    public static class Lotto {
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
            validate(numbers);
            this.numbers = numbers;
        }

        private void validate(List<Integer> numbers) {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            }
        }

        public List<Integer> getNumbers() {
            return numbers;
        }
    }
}

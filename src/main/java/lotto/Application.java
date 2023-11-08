package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount;

        try {
            purchaseAmount = Integer.parseInt(scanner.nextLine());
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력하세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        int numberOfLottoTickets = purchaseAmount / 1000;
        List<Lotto> purchasedLottoTickets = generateLottoTickets(numberOfLottoTickets);


        System.out.println(numberOfLottoTickets + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottoTickets) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = parseInputNumbers(scanner);


        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());

        int[] result = calculateResult(purchasedLottoTickets, winningNumbers, bonusNumber);
        displayResult(result,purchaseAmount);
    }

    private static List<Lotto> generateLottoTickets(int numberOfLottoTickets) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfLottoTickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTickets.add(new Lotto(numbers));
        }
        return lottoTickets;
    }

    private static List<Integer> parseInputNumbers(Scanner scanner) {
        while (true) {
            System.out.println("로또 번호를 입력해 주세요.");
            try {
                List<Integer> numbers = Arrays.stream(scanner.nextLine().split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                if (numbers.size() != 6 || numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }

                Set<Integer> numberSet = new HashSet<>(numbers);
                if (numberSet.size() != 6) {
                    throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
                }

                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int[] calculateResult(List<Lotto> purchasedLottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        int[] result = new int[6]; // 1st to 6th place

        for (Lotto lotto : purchasedLottoTickets) {
            int matchedNumbers = countMatchingNumbers(lotto, winningNumbers);
            if (matchedNumbers == 6) {
                result[0]++;
            } else if (matchedNumbers == 5 && lotto.getNumbers().contains(bonusNumber)) {
                result[1]++;
            } else if (matchedNumbers == 5) {
                result[2]++;
            } else if (matchedNumbers == 4) {
                result[3]++;
            } else if (matchedNumbers == 3) {
                result[4]++;
            }
        }
        return result;
    }

    private static int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static void displayResult(int[] result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + result[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[0] + "개");

        int totalPrize = result[4] * 5000 + result[3] * 50000 + result[2] * 1500000 + result[1] * 30000000 + result[0] * 2000000000;
        double profitRate = (totalPrize / (double) purchaseAmount) * 100.0;
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}
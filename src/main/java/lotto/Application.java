package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
        boolean bonusball = false;
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요: ");
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottoTickets = purchaseAmount / 1000;

        System.out.println(numberOfLottoTickets + "개를 구매했습니다.");

        List<Lotto> lottos = generateLottos(numberOfLottoTickets);

        System.out.println("당첨 번호를 입력해 주세요: ");
        String winningNumbersInput = Console.readLine();
        List<Integer> winningNumbers = parseNumbers(winningNumbersInput);

        System.out.println("보너스 번호를 입력해 주세요: ");
        int bonusNumber = Integer.parseInt(Console.readLine());

        int[] matchCounts = countMatches(lottos, winningNumbers, bonusNumber);

        printLottoNumbers(lottos);
        printWinningStats(matchCounts, numberOfLottoTickets);
    }

    private static int getPurchaseAmount() {
        while (true) {
            try {
               String input = Console.readLine();
                int amount = Integer.parseInt(input);

                if (amount <= 0) {
                    System.out.println("[ERROR] 구입 금액은 양수여야 합니다.");
                } else if (amount % 1000 != 0) {
                    System.out.println("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                } else {
                    return amount;
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            }
        }
    }

    private static List<Lotto> generateLottos(int numberOfTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static List<Integer> parseNumbers(String input) {
        String[] numberTokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : numberTokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return numbers;
    }

    private static int[] countMatches(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCounts = new int[7]; // 7로 변경
        for (Lotto lotto : lottos) {
            int count = countMatch(lotto.getNumbers(), winningNumbers);
            if (count == 5 && lotto.getNumbers().contains(bonusNumber)) {


            }
            matchCounts[count]++;

        }
        return matchCounts;
    }

    private static int countMatch(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }


    private static void printWinningStats(int[] matchCounts, int numberOfLottoTickets) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (int i = 2; i <= 6; i++) {
            String matchText = i + "개 일치";
            int prize = calculatePrize(i);
            int count = matchCounts[i];




            System.out.printf("%s (%s) - %d개\n", matchText, formatPrize(prize), count);
            if(i==5)
            {System.out.printf("%s, 보너스 볼 일치 (%s) - %d개\n", matchText, formatPrize(calculatePrize(7)), count);
            }
        }



        double totalPrize = calculateTotalPrize(matchCounts);
        double investment = numberOfLottoTickets * 1000;
        double profitRatio = (totalPrize / investment) * 100;
        System.out.println("총 수익률은 " + formatPercentage(profitRatio) + "입니다.");
    }

    private static int calculatePrize(int matchCount) {
        switch (matchCount) {
            case 3:
                return 5000;
            case 4:
                return 50000;
            case 5:
                return 1500000;
            case 7:
                return 30000000;
            case 6:
                return 2000000000;
            default:
                return 0;
        }
    }


    private static double calculateTotalPrize(int[] matchCounts) {
        double totalPrize = 0;
        for (int i = 0; i <= 6; i++) {
            totalPrize += calculatePrize(i) * matchCounts[i];
        }
        return totalPrize;
    }

    private static String formatPrize(int prize) {

            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            return decimalFormat.format(prize) + "원";


    }

    private static String formatPercentage(double percentage) {
        return String.format("%.1f%%", percentage);
    }
}

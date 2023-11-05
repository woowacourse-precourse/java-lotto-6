package lotto;

import domain.Lotto;
import domain.LottoGameResult;
import domain.LottoTicket;
import domain.PaymentCalculator;
import domain.WinningNumbers;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());

        LottoTicket ticket = PaymentCalculator.purchaseLottoTicket(amount);

        System.out.println(ticket.getLottoNumbers().size() + "개를 구매했습니다.");
        for (Lotto lotto : ticket.getLottoNumbers()) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        List<Integer> winningNumbers = parseNumbers(winningNumbersInput);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        WinningNumbers winningNumbersObj = new WinningNumbers(new Lotto(winningNumbers), bonusNumber);

        LottoGameResult result = calculateResult(ticket, winningNumbersObj);
        printResult(result);
    }

    private static List<Integer> parseNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString));
        }
        return numbers;
    }

    private static LottoGameResult calculateResult(LottoTicket ticket, WinningNumbers winningNumbers) {
        Map<Integer, Long> matchCounts = new HashMap<>();
        for (Lotto lotto : ticket.getLottoNumbers()) {
            int matchCount = countMatchingNumbers(lotto, winningNumbers.getWinningLotto());
            matchCounts.put(matchCount, matchCounts.getOrDefault(matchCount, 0L) + 1);
        }
        return new LottoGameResult(matchCounts);
    }

    private static int countMatchingNumbers(Lotto userLotto, Lotto winningLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int matchCount = 0;

        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static void printResult(LottoGameResult result) {
        Map<Integer, Long> matchCounts = result.getMatchCounts();
        System.out.println("당첨 통계");
        System.out.println("---");
        printMatchResult(matchCounts, 6, "6개 일치 (2,000,000,000원)");
        printMatchResult(matchCounts, 5, "5개 일치 (1,500,000원)");
        printMatchResult(matchCounts, 5, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        printMatchResult(matchCounts, 4, "4개 일치 (50,000원)");
        printMatchResult(matchCounts, 3, "3개 일치 (5,000원)");

        double totalPrize = calculateTotalPrize(matchCounts);
        double totalInvestment = result.getMatchCounts().values().stream().mapToLong(Long::longValue).sum() * 1000;
        double profitRate = (totalPrize / totalInvestment) * 100;

        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }

    private static void printMatchResult(Map<Integer, Long> matchCounts, int matchCount, String prize) {
        long count = matchCounts.getOrDefault(matchCount, 0L);
        System.out.println(matchCount + "개 일치 " + prize + " - " + count + "개");
    }
}
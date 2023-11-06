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
import java.util.Set;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        int amount = getAmount();

        LottoTicket ticket = PaymentCalculator.purchaseLottoTicket(amount);
        printPurchasedLottos(ticket);

        WinningNumbers winningNumbers = getWinningNumbers();

        LottoGameResult result = calculateResult(ticket, winningNumbers);
        printResult(result);
    }

    private static int getAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static WinningNumbers getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        List<Integer> winningNumbers = parseNumbers(winningNumbersInput);
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();
        return new WinningNumbers(new Lotto(winningNumbers), bonusNumber);
    }

    private static List<Integer> parseNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString));
        }
        return numbers;
    }

    private static void printPurchasedLottos(LottoTicket ticket) {
        List<Lotto> lottos = ticket.getLottoNumbers();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static LottoGameResult calculateResult(LottoTicket ticket, WinningNumbers winningNumbers) {
        Map<Integer, Long> matchCounts = new HashMap<>();
        for (Lotto lotto : ticket.getLottoNumbers()) {
            int matchCount = countMatchingNumbers(lotto, winningNumbers);
            matchCounts.put(matchCount, matchCounts.getOrDefault(matchCount, 0L) + 1);
        }
        return new LottoGameResult(matchCounts);
    }

    private static int countMatchingNumbers(Lotto userLotto, WinningNumbers winningNumbers) {
        Set<Integer> userNumbers = new HashSet<>(userLotto.getNumbers());
        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers.getWinningLotto().getNumbers());

        userNumbers.retainAll(winningNumbersSet);

        int matchCount = userNumbers.size();
        if (matchCount == 5 && userNumbers.contains(winningNumbers.getBonusNumber())) {
            matchCount = 6;
        }

        return matchCount;
    }

    private static void printResult(LottoGameResult result) {
        Map<Integer, Long> matchCounts = result.getMatchCounts();
        System.out.println("당첨 통계");
        System.out.println("---");
        printMatchResult(matchCounts, 3, "3개 일치 (5,000원)");
        printMatchResult(matchCounts, 4, "4개 일치 (50,000원)");
        printMatchResult(matchCounts, 5, "5개 일치 (1,500,000원)");
        printMatchResult(matchCounts, 5, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        printMatchResult(matchCounts, 6, "6개 일치 (2,000,000,000원)");

        double totalPrize = calculateTotalPrize(matchCounts);
        double totalInvestment = matchCounts.values().stream().mapToLong(Long::longValue).sum() * 1000;
        double profitRate = (totalPrize / totalInvestment) * 100;

        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }

    private static void printMatchResult(Map<Integer, Long> matchCounts, int matchCount, String prize) {
        long count = matchCounts.getOrDefault(matchCount, 0L);
        System.out.println(matchCount + "개 일치 " + prize + " - " + count + "개");
    }

    private static double calculateTotalPrize(Map<Integer, Long> matchCounts) {
        double totalPrize = 0;
        totalPrize += matchCounts.getOrDefault(6, 0L) * 2_000_000_000;
        totalPrize += matchCounts.getOrDefault(5, 0L) * 1_500_000;
        totalPrize += matchCounts.getOrDefault(5, 0L) * 30_000_000;
        totalPrize += matchCounts.getOrDefault(4, 0L) * 50_000;
        totalPrize += matchCounts.getOrDefault(3, 0L) * 5_000;
        return totalPrize;
    }
}
package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningResult;
import lotto.model.LottoNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public void startNewGame() {
        int purchaseAmount = getPurchaseAmount();
        int numberOfTickets = purchaseAmount / Lotto.TICKET_PRICE;
        List<List<Integer>> purchasedTickets = generatePurchasedTickets(numberOfTickets);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        List<WinningResult> winningResults = calculateWinningResults(purchasedTickets, winningNumbers, bonusNumber);

        printNumberOfPurchasedTickets(numberOfTickets);
        printWinningResults(winningResults);
    }

    public int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<List<Integer>> generatePurchasedTickets(int count) {
        List<List<Integer>> purchasedTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generateRandomLottoNumbers();
            Collections.sort(lottoNumbers);
            purchasedTickets.add(lottoNumbers);
        }
        return purchasedTickets;
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<WinningResult> calculateWinningResults(List<List<Integer>> purchasedTickets, List<Integer> winningNumbers, int bonusNumber) {
        List<WinningResult> results = new ArrayList<>();
        for (List<Integer> ticket : purchasedTickets) {
            int matchingCount = calculateMatchingCount(ticket, winningNumbers);
            boolean hasBonusNumber = ticket.contains(bonusNumber);

            results.add(new WinningResult(matchingCount, hasBonusNumber));
        }
        return results;
    }

    private int calculateMatchingCount(List<Integer> ticket, List<Integer> winningNumbers) {
        long matchingCount = ticket.stream()
                .filter(winningNumbers::contains)
                .count();
        return (int) matchingCount;
    }

    public void printNumberOfPurchasedTickets(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
        if (count > 0) {
            System.out.println("구매한 로또 번호는 다음과 같습니다:");
            for (List<Integer> ticket : generatePurchasedTickets(count)) {
                System.out.println(ticket);
            }
        }
    }

    public void printWinningResults(List<WinningResult> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int[] matchCounts = new int[7]; // 0부터 6까지의 인덱스를 가질 배열 생성
        for (WinningResult result : results) {
            int matchingCount = result.getMatchingCount();
            matchCounts[matchingCount]++; // 매칭 카운트에 따른 배열 인덱스 증가
        }

        for (int i = 3; i <= 6; i++) {
            int winningAmount = calculateWinningAmount(i, false);
            System.out.printf("%d개 일치 (%,d원) - %d개%n", i, winningAmount, matchCounts[i]);
        }

        int bonusMatchingCount = matchCounts[5];
        if (bonusMatchingCount > 0) {
            int winningAmount = calculateWinningAmount(5, true);
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", 5, winningAmount, bonusMatchingCount);
        }

        System.out.println("총 수익률은 " + calculateTotalProfitRate(results) + "%입니다.");
    }

    private int calculateWinningAmount(int matchingCount, boolean hasBonusNumber) {
        int winningAmount = 0;

        if (matchingCount == 3) {
            winningAmount = 5_000;
        }
        if (matchingCount == 4) {
            winningAmount = 50_000;
        }
        if (matchingCount == 5 && hasBonusNumber) {
            winningAmount = 30_000_000;
        }
        if (matchingCount == 5 && !hasBonusNumber) {
            winningAmount = 1_500_000;
        }
        if (matchingCount == 6) {
            winningAmount = 2_000_000_000;
        }

        return winningAmount;
    }


    private double calculateTotalProfitRate(List<WinningResult> results) {
        int totalWinningAmount = results.stream()
                .mapToInt(result -> calculateWinningAmount(result.getMatchingCount(), result.hasBonusNumber()))
                .sum();

        int totalPurchasePrice = results.size() * Lotto.TICKET_PRICE;
        return (double) totalWinningAmount / totalPurchasePrice * 100;
    }
}

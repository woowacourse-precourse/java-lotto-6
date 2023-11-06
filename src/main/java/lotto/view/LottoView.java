package lotto.view;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.stream.Collectors;
import lotto.model.WinningResult;
import lotto.model.LottoNumberGenerator;
import lotto.Lotto;

public class LottoView {
    public int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public void printNumberOfPurchasedTickets(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
        if (count > 0) {
            System.out.println("구매한 로또 번호는 다음과 같습니다:");
            for (int i = 0; i < count; i++) {
                List<Integer> lottoNumbers = LottoNumberGenerator.generateRandomLottoNumbers();
                Collections.sort(lottoNumbers);
                System.out.println(lottoNumbers);
            }
        }
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

    public void printWinningResults(List<WinningResult> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int[] matchCounts = new int[6];
        for (WinningResult result : results) {
            int matchingCount = result.getMatchingCount();
            if (matchingCount >= 3) {
                matchCounts[matchingCount] += 1;
            }
        }

        for (int i = 3; i <= 5; i++) {
            System.out.printf("%d개 일치 (%,d원) - %d개%n", i, calculateWinningAmount(i), matchCounts[i]);
        }

        int matchingCount = 5;
        boolean hasBonusNumber = false;
        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", matchingCount, calculateWinningAmount(matchingCount, hasBonusNumber), matchCounts[matchingCount]);
        System.out.println("총 수익률은 " + calculateTotalProfitRate(results) + "%입니다.");
    }

    private int calculateWinningAmount(int matchingCount) {
        return switch (matchingCount) {
            case 3 -> 5_000;
            case 4 -> 50_000;
            case 5 -> 1_500_000;
            default -> 0;
        };
    }

    private int calculateWinningAmount(int matchingCount, boolean hasBonusNumber) {
        if (matchingCount == 5 && hasBonusNumber) {
            return 30_000_000;
        }
        return 0;
    }

    private double calculateTotalProfitRate(List<WinningResult> results) {
        int totalWinningAmount = results.stream()
                .mapToInt(result -> calculateWinningAmount(result.getMatchingCount(), result.hasBonusNumber()))
                .sum();

        int totalPurchasePrice = results.size() * Lotto.TICKET_PRICE;
        return (double) totalWinningAmount / totalPurchasePrice * 100;
    }

}

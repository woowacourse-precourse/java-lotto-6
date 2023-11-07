package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningResult;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoGame;

import java.util.*;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public void startNewGame() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> purchasedLottos = generatePurchasedLottos(purchaseAmount);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        LottoGame lottoGame = new LottoGame();
        List<WinningResult> winningResults = lottoGame.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);
        int count = purchasedLottos.size();
        printNumberOfPurchasedTickets(count, purchasedLottos);
        printWinningResults(winningResults);
    }

    public int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Lotto> generatePurchasedLottos(int count) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generateRandomLottoNumbers();
            purchasedLottos.add(new Lotto(lottoNumbers));
        }
        return purchasedLottos;
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

    public void printNumberOfPurchasedTickets(int count, List<Lotto> purchasedLottos) {
        System.out.printf("%d개를 구매했습니다.%n", count);
        if (count > 0) {
            for (Lotto lotto : purchasedLottos) {
                List<Integer> lottoNumbers = lotto.getNumbers(); // Lotto 클래스에서 삭제한 부분 수정
                System.out.println(lottoNumbers);
            }
        }
    }

    public void printWinningResults(List<WinningResult> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int[] matchCounts = new int[7];
        for (WinningResult result : results) {
            int matchingCount = result.getMatchingCount();
            matchCounts[matchingCount]++;
        }

        for (int i = 3; i <= 6; i++) {
            int winningAmount = calculateWinningAmount(i, false);
            int matchingCount = matchCounts[i];
            System.out.printf("%d개 일치 (%,d원) - %d개%n", i, winningAmount, matchingCount);
            if (i == 5) {
                int bonusMatchingCount = matchCounts[5];
                int bonusWinningAmount = calculateWinningAmount(5, true);
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", i, bonusWinningAmount, bonusMatchingCount);
            }
        }

        // 6개 일치에 대한 내용 출력
        int matchingCount6 = matchCounts[6];
        if (matchingCount6 > 0) {
            int winningAmount6 = calculateWinningAmount(6, false);
            System.out.printf("6개 일치 (%,d원) - %d개%n", winningAmount6, matchingCount6);
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f%%", profitRate) + "입니다.");
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

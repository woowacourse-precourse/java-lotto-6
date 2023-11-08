package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {

    private static final int PRICE_PER_LOTTO = 1000; // 가정한 로또 가격

    public static void main(String[] args) {
        try {
            int purchaseAmount = readPurchaseAmount();
            int numberOfLottos = purchaseAmount / PRICE_PER_LOTTO;

            LottoMachine lottoMachine = new LottoMachine(new LottoGenerator());
            lottoMachine.purchaseLottos(numberOfLottos);
            displayPurchasedLottos(lottoMachine);

            // 당첨 번호를 먼저 읽어온다.
            List<Integer> winningNumbers = readWinningNumbers();
            // 보너스 번호를 읽어오는데, 당첨 번호 목록을 인수로 전달한다.
            int bonusNumber = readBonusNumber(winningNumbers);

            LottoResults lottoResults = lottoMachine.drawWinningNumbers(winningNumbers, bonusNumber);
            displayResults(lottoResults);

            double profitRate = lottoResults.calculateProfitRate(purchaseAmount);
            System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            // 에러 발생시 다시 main 함수를 호출하여 재시작할 수 있습니다.
            main(args);
        }
    }

    private static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        if (purchaseAmount < PRICE_PER_LOTTO || purchaseAmount % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
        return purchaseAmount;
    }

    private static void displayPurchasedLottos(LottoMachine lottoMachine) {
        System.out.println(lottoMachine.getPurchasedLottos().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoMachine.getPurchasedLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
        }
    }
    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6 || new HashSet<>(winningNumbers).size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        if (winningNumbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    private static int readBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("보너스 번호는 당첨 번호와 달라야 합니다.");
            }
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }
    }

    private static void displayResults(LottoResults lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE) // NONE을 제외
                .sorted(Comparator.comparingInt(LottoRank::getMatchCount)) // 당첨 숫자 기준 오름차순 정렬
                .forEach(rank -> {
                    String bonusMatch = rank == LottoRank.SECOND ? ", 보너스 볼 일치" : "";
                    System.out.println(rank.getMatchCount() + "개 일치" + bonusMatch + " (" + String.format("%,d", rank.getReward()) + "원) - " + lottoResults.getCount(rank) + "개");
                });
    }
}

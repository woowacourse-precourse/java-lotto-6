package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private Lotto winningLotto;

    public void run() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int purchaseAmount = lottoGenerator.getPurchaseAmount();
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);

        System.out.println(purchaseAmount / LottoGenerator.TICKET_PRICE + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            saveLottoNumbers(lotto);
        }

        getWinningLotto();
        GameResult gameResult = new GameResult(lottos, winningLotto, getBonusNumber());
        printResult(gameResult, purchaseAmount);
    }

    private void printResult(GameResult gameResult, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printWinningStatistics(gameResult.getResults());

        ProfitCalculator profitCalculator = new ProfitCalculator();
        double profitRate = profitCalculator.calculateProfitRate(purchaseAmount, gameResult.getResults());
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    private void getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        String[] numberStrings = input.split(",");

        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            numbers.add(number);
        }

        winningLotto = new Lotto(numbers);
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int number = Integer.parseInt(input);

        if (winningLotto.containsNumber(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        return number;
    }

    private void saveLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbersInAscendingOrder().toString());
    }

    private void printWinningStatistics(List<Rank> results) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        for (Rank rank : Rank.values()) {
            int count = countRank(results, rank);
            String formattedPrizeMoney = decimalFormat.format(rank.getPrizeMoney());
            if (rank == Rank.FIFTH || rank == Rank.FOURTH || rank == Rank.THIRD || rank == Rank.FIRST) {
                String result = String.format("%d개 일치 (%s원) - %d개", rank.getMatchCount(), formattedPrizeMoney, count);
                System.out.println(result);
            } else if (rank == Rank.SECOND) {
                String result = String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", rank.getMatchCount(), formattedPrizeMoney, count);
                System.out.println(result);
            }
        }
    }

    private int countRank(List<Rank> results, Rank rank) {
        int count = 0;
        for (Rank result : results) {
            if (result == rank) {
                count++;
            }
        }
        return count;
    }
}

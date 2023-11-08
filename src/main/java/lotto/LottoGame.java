package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoEnum.normalBallHitted;
import static lotto.LottoEnum.prize;
import static lotto.LottoEnum.prizeScores;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.StringParser;

public class LottoGame {
    private final LottoVendor lottoVendor = new LottoVendor(LottoEnum.PRICE.getValue());
    private Integer money;

    public List<Lotto> purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                money = getMoney();
                return lottoVendor.purchaseAll(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer getMoney() {
        while (true) {
            try {
                return StringParser.toInteger(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                List<Integer> winningNumbers = StringParser.toIntegers(readLine());
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public LottoChecker getResult() {
        Lotto winner = getWinningNumbers();
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                Integer bonus = StringParser.toInteger(readLine());
                return new LottoChecker(winner, bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<Integer, Integer> createPrizeScoreToCountPrizes(List<Integer> scores) {
        Map<Integer, Integer> prizeScoreToCountPrizes = new HashMap<>();
        for (Integer prizeScore : prizeScores) {
            prizeScoreToCountPrizes.put(prizeScore, 0);
        }
        for (Integer score : scores) {
            if (prizeScores.contains(score)) {
                prizeScoreToCountPrizes.put(score, prizeScoreToCountPrizes.get(score) + 1);
            }
        }
        return prizeScoreToCountPrizes;
    }

    public void printScores(List<Integer> scores) {
        Map<Integer, Integer> prizeScoreToCountPrizes = createPrizeScoreToCountPrizes(scores);
        NumberFormat numberFormat = NumberFormat.getInstance();
        for (int i = 0; i < prizeScoreToCountPrizes.size(); ++i) {
            System.out.printf("%d개 일치", normalBallHitted.get(i));
            if (i == 3) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.printf(" (%s원) - %d개\n", numberFormat.format(prize.get(i)),
                    prizeScoreToCountPrizes.get(prizeScores.get(i)));
        }
    }

    public void printProfitRate(List<Integer> totalPrizes) {
        int sum = totalPrizes.stream().reduce(0, Integer::sum);
        double profitRate = (double) sum / money * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (double) Math.round(profitRate * 10) / 10);
    }
}

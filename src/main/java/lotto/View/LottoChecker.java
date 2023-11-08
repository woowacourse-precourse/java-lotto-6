package lotto.View;

import lotto.Model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    private static final String CHECK_START_MESSAGE = "\n당첨 통계\n---";
    private static List<Lotto> boughtLottos;
    private static List<Integer> winningNumbers;
    private static Integer bonusNumber;
    private static Integer bonusWinCount = 0;
    public static final Integer FIRST_PRIZE = PrizeMoney.FIRST.getPrizeAmount();
    public static final Integer SECOND_PRIZE = PrizeMoney.SECOND.getPrizeAmount();
    public static final Integer THIRD_PRIZE = PrizeMoney.THIRD.getPrizeAmount();
    public static final Integer FOURTH_PRIZE = PrizeMoney.FOURTH.getPrizeAmount();
    public static final Integer FIFTH_PRIZE = PrizeMoney.FIFTH.getPrizeAmount();

    public LottoChecker(List<Lotto> givenBoughtLottos, List<Integer> givenWinningNumbers, Integer givenBonusNumber) {
        boughtLottos = givenBoughtLottos;
        winningNumbers = givenWinningNumbers;
        bonusNumber = givenBonusNumber;
    }

    public static void printCheckStart() {
        System.out.println(CHECK_START_MESSAGE);
    }

    private static List<Integer> checkWinning() {
        List<Integer> counts = new ArrayList<>();
        for (Lotto boughtLotto : boughtLottos) {
            Integer count = 0;
            List<Integer> boughtNumbers = boughtLotto.getNumbers();
            for (Integer winningNumber : winningNumbers) {
                if (boughtNumbers.contains(winningNumber)) {
                    count++;
                    if ((count == 5) & boughtNumbers.contains(bonusNumber)) {
                        bonusWinCount++;
                    }
                }
            }
            counts.add(count);
        }
        return counts;
    }

    public static void checkWinningCounts() {
        List<Integer> counts = checkWinning();
        Integer winCount = 0;
        Integer winningAmount = 0;
        winCount = Integer.parseInt(String.valueOf(counts.stream().filter(x -> x == 3).count()));
        winningAmount += winCount * 5_000;
        System.out.println(String.format("3개 일치 (5,000원) - %d개", winCount));

        winCount = Integer.parseInt(String.valueOf(counts.stream().filter(x -> x == 4).count()));
        winningAmount += winCount * 50_000;
        System.out.println(String.format("4개 일치 (50,000원) - %d개", winCount));

        winCount = Integer.parseInt(String.valueOf(counts.stream().filter(x -> x == 5).count()));
        winningAmount += winCount * 1_500_000;
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", winCount));

        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", bonusWinCount));
        winCount = Integer.parseInt(String.valueOf(counts.stream().filter(x -> x == 6).count()));
        winningAmount += winCount * 2_000_000_000;
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", winCount));

        System.out.println(String.format("총 수익률은 %.1f%%입니다.", (double) winningAmount / LottoBuyer.money));
    }
}

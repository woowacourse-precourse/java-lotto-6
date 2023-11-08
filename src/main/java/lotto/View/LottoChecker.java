package lotto.View;

import lotto.Model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    private static final String CHECK_START_MESSAGE = "\n당첨 통계\n---";
    private static List<Lotto> boughtLottos;
    private static List<Integer> winningNumbers;
    public static final Integer FIRST_PRIZE = PrizeMoney.FIRST.getPrizeAmount();
    public static final Integer SECOND_PRIZE = PrizeMoney.SECOND.getPrizeAmount();
    public static final Integer THIRD_PRIZE = PrizeMoney.THIRD.getPrizeAmount();
    public static final Integer FOURTH_PRIZE = PrizeMoney.FOURTH.getPrizeAmount();
    public static final Integer FIFTH_PRIZE = PrizeMoney.FIFTH.getPrizeAmount();

    public LottoChecker(List<Lotto> givenBoughtLottos, List<Integer> givenWinningNumbers) {
        boughtLottos = givenBoughtLottos;
        winningNumbers = givenWinningNumbers;
    }

    public static void printCheckStart() {
        System.out.println(CHECK_START_MESSAGE);
    }

    public static void checkWinning() {
        List<Integer> counts = new ArrayList<>();
        for (Lotto boughtLotto : boughtLottos) {
            Integer count = 0;
            List<Integer> boughtNumbers = boughtLotto.getNumbers();
            for (Integer winningNumber : winningNumbers) {
                if (boughtNumbers.contains(winningNumber)) {
                    count++;
                }
            }
            counts.add(count);
            System.out.println(String.format("당첨 개수: %d", count));
        }
        System.out.println(counts);
    }
}

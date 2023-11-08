package lotto.util;

import lotto.model.PrizeResultDto;
import lotto.enumration.Prize;
import lotto.model.Lotto;
import java.util.List;

public class CalculateMatch {

    private static int matchCount;
    private static boolean matchBonus;
    private static int totalPrize = 0;
    private static int[] totalPrizeCount = new int[6];

    //등수와 총금액 반환
    public static PrizeResultDto calculate(List<Lotto> lottoList, Lotto winningLotto, int winningBonusNumber) {

        for (Lotto lotto : lottoList) {
            dataReset();

            calculateMatchCount(lotto, winningLotto.getNumbers());
            calculateMatchBonus(lotto, winningBonusNumber);

            Prize prize = Prize.of(matchCount, matchBonus);

            totalPrize += prize.getWinningMoney();
            totalPrizeCount[prize.getRank()]++;
        }

        return PrizeResultDto.of(totalPrizeCount, totalPrize);
    }

    public static void dataReset(){
        matchCount = 0;
        matchBonus = false;
    }

    public static void calculateMatchCount(Lotto lotto, List<Integer> winningNumberList) {

        for (int number : lotto.getNumbers()) {
            isContain(winningNumberList, number);
        }

    }

    private static void isContain(List<Integer> winningNumberList, int number) {

        if (winningNumberList.contains(number)) {
            matchCount++;
        }

    }

    public static void calculateMatchBonus(Lotto lotto, int winningBonusNumber) {
        matchBonus = lotto.getNumbers().contains(winningBonusNumber);
    }

}

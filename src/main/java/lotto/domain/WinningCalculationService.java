package lotto.domain;

public class WinningCalculationService {    //도메인 서비스

    public static Rank calculateRank(final Lotto lotto, final LuckyNumbers luckyNumbers) {
        return Rank.find(lotto.compareNumbers(luckyNumbers.getWinningNumbers()),
                                                lotto.contains(luckyNumbers.getBonusNumber()));
    }

}

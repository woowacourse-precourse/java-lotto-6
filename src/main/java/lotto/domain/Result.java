package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Result {
    FIFTH(3, 5_000, 0),
    FOURTH(4, 50_000, 0),
    THIRD(5, 1_500_000, 0),
    SECOND(5, 30_000_000, 0),
    FIRST(6, 2_000_000_000, 0);

    private final int matchCount;
    private final int winningMoney;
    private int status;

    Result(int matchCount, int winningMoney, int status) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.status = status;
    }

    public static List<Result> getResults(){
        return List.of(Result.values());
    }

    public static Result[] getAllLottoResult(
        Lottos lottos,
        Lotto userLottoNumbers,
        int BonusNumber
    ) {
            getLottoResults(lottos, userLottoNumbers, BonusNumber);
        return Result.values();
    }

    private static void getLottoResults(Lottos lottos, Lotto userLottoNumbers, int BonusNumber) {
        for(Lotto lotto : lottos. getLottos()) {
            int matchCount = lotto.getMatchCount(userLottoNumbers);
            boolean isBonusNumber = lotto.checkDuplicate(BonusNumber);
            findprize(matchCount, isBonusNumber);
        }
    }

    private static void findprize(int matchCount, boolean bonusNumber) {
        if (FIRST.matchCount == matchCount) {
            FIRST.status++;
        }
        if (SECOND.matchCount == matchCount && bonusNumber) {
            SECOND.status++;
        }
        if (THIRD.matchCount == matchCount) {
            THIRD.status++;
        }
        if (FOURTH.matchCount == matchCount) {
            FOURTH.status++;
        }
        if (FIFTH.matchCount == matchCount) {
            FIFTH.status++;
        }
    }


    public static double getProfitRate(Result[] results, int userMoney) {
        return (double) Arrays.stream(results)
            .mapToInt(result -> result.getWinningMoney() * result.getStatus())
            .sum() / userMoney * 100;
    }



    public int getStatus() {
        return status;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}

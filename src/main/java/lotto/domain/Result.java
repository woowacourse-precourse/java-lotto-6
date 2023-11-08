package lotto.domain;

import static lotto.global.Constants.PERCENTAGE;

import java.util.Arrays;
import java.util.List;
import lotto.dto.ResultsDto;

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

    public static ResultsDto getAllLottoResults(
            List<Lotto> lottos,
            Lotto winningLottoNumber,
            int BonusNumber
    ) {
        setLottoResults(lottos, winningLottoNumber, BonusNumber);
        return new ResultsDto(Result.values());
    }

    private static void setLottoResults(
            List<Lotto> lottos,
            Lotto winningLottoNumber,
            int BonusNumber
    ) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningLottoNumber);
            boolean isBonusNumber = lotto.checkDuplicateNumber(BonusNumber);
            findprize(matchCount, isBonusNumber);
        }
    }

    private static void findprize(int matchCount, boolean bonusNumber) {
        if (FIRST.matchCount == matchCount) {
            FIRST.status++;
            return;
        }
        if (SECOND.matchCount == matchCount && bonusNumber) {
            SECOND.status++;
            return;
        }
        if (THIRD.matchCount == matchCount && !bonusNumber) {
            THIRD.status++;
            return;
        }
        if (FOURTH.matchCount == matchCount) {
            FOURTH.status++;
            return;
        }
        if (FIFTH.matchCount == matchCount) {
            FIFTH.status++;
        }
    }

    public static double getProfitRate(Result[] results, int userMoney) {
        return (double) Arrays.stream(results)
                .mapToInt(result -> result.getWinningMoney() * result.getStatus())
                .sum() / userMoney * PERCENTAGE;
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
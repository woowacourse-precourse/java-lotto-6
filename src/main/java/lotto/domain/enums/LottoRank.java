package lotto.domain.enums;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.LottoConstant.MIN_MATCH_COUNT_FOR_BONUS;

public enum LottoRank {
    NONE(0, 0, false, "꽝"),
    FIFTH(5000, 3, false, "3개 일치 (5,000원) - "),
    FOURTH(50000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1500000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30000000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2000000000, 6, false, "6개 일치 (2,000,000,000원) - ");

    private final int prize;
    private final int matchCount;
    private final boolean matchBonus;
    private final String message;

    LottoRank(int prize, int matchCount, boolean matchBonus, String message) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.message = message;
    }

    public static LottoRank getResult(Lotto lotto, WinningNumber winningNumber) {
        Lotto winningLotto = winningNumber.getWinningNumber();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        int matchCountResult = getMatchCountResult(lotto, winningNumbers);

        boolean matchBonusResult = false;
        if (matchCountResult == MIN_MATCH_COUNT_FOR_BONUS.getValue()) {
            matchBonusResult = lotto.isContain(winningNumber.getBonusNumber());
        }

        return getRank(matchCountResult, matchBonusResult);
    }

    private static int getMatchCountResult(Lotto lotto, List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(lotto::isContain)
                .count();
    }

    private static LottoRank getRank(int matchCountResult, boolean matchBonusResult) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == matchCountResult)
                .filter(lottoRank -> lottoRank.matchBonus == matchBonusResult)
                .findAny()
                .orElse(NONE);
    }

    public long calculate(int count) {
        return (long) prize * count;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}

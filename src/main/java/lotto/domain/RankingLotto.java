package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum RankingLotto {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ",
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 6), // 1등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && containBonusNumber), // 2등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - ",
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && !containBonusNumber), // 3등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - ",
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 4), // 4등
    FIFTH(3, 5_000, "3개 일치 (5,000원) - ",
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 3), // 5등
    EMPTY(0, 0, "",
            (matchLottoNumber, containBonusNumber) -> matchLottoNumber < 3);

    private int matchLottoNumber;
    private int prizeMoney;
    private String message;
    private final BiPredicate<Integer, Boolean> isMatch;

    RankingLotto(int matchLottoNumber, int prizeMoney, String message, final BiPredicate<Integer, Boolean> isMatch) {
        this.matchLottoNumber = matchLottoNumber;
        this.prizeMoney = prizeMoney;
        this.message = message;
        this.isMatch = isMatch;
    }

    public static RankingLotto getPrize(final int matchLottoNumber, final boolean containBonusNumber) {
        return Arrays.stream(RankingLotto.values())
                .filter(rank -> rank.isMatch.test(matchLottoNumber, containBonusNumber))
                .findAny()
                .orElse(EMPTY);
    }

    public int getMatchLottoNumber() {
        return matchLottoNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {return message;}
}

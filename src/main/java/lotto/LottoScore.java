package lotto;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoScore {
    FIRST_PLACE(1, 6, 0, 2_000_000_000),
    SECOND_PLACE(2, 5, 1, 30_000_000),
    THIRD_PLACE(3, 5, 0, 1_500_000),
    FOURTH_PLACE(4, 4, 0, 50_000),
    FIFTH_PLACE(5, 3, 0, 5_000),
    NOTHING_PLACE(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 0);
    private int place;
    private long matchLottoNumbers;
    private long matchBonusLottoNumbers;
    private long reward;

    LottoScore(int place, int matchLottoNumbers, int matchBonusLottoNumbers, long reward) {
        this.place = place;
        this.matchLottoNumbers = matchLottoNumbers;
        this.matchBonusLottoNumbers = matchBonusLottoNumbers;
        this.reward = reward;
    }

    public static LottoScore getMatchLottoScore(long matchLottoNumbers, long matchBonusLottoNumbers) {
        return Arrays.stream(values())
                .filter(lottoScore -> lottoScore.matchLottoNumbers <= matchLottoNumbers
                        && lottoScore.matchBonusLottoNumbers <= matchBonusLottoNumbers)
                .min(Comparator.comparing(lottoScore -> lottoScore.place))
                .orElse(NOTHING_PLACE);
    }

    public long getReward() {
        return reward;
    }
}
/*
- 1등: 6개 번호 일치 / 2,000,000,000원
- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
- 3등: 5개 번호 일치 / 1,500,000원
- 4등: 4개 번호 일치 / 50,000원
- 5등: 3개 번호 일치 / 5,000원
 */


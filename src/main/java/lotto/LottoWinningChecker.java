package lotto;

import java.util.List;

public class LottoWinningChecker {
    private static final int FIFTH_PRIZE_MATCHING_COUNT = 3;
    private static final int FOURTH_PRIZE_MATCHING_COUNT = 4;
    private static final int THIRD_PRIZE_MATCHING_COUNT = 5;

    private final List<LottoNumber> lottoResult;
    private final LottoNumber bonusNumber;

    LottoWinningChecker(List<Integer> lottoWinningNumber, Integer bonusNumber) {
        validate(lottoWinningNumber);
        this.lottoResult = lottoWinningNumber.stream()
                .map(LottoNumber::new)
                .toList();

        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validate(List<Integer> lottoWinningNumber) {
        if (lottoWinningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 갯수는 6개 입니다.");
        }
    }

    private int matchCount(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoResult) {
            if (lotto.containLottoNumber(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private LottoResult matchBonusNumber(Lotto lotto) {
        if (lotto.containLottoNumber(bonusNumber)) {
            return LottoResult.SECOND_PRIZE;
        }
        return LottoResult.THIRD_PRIZE;
    }

    public LottoResult check(Lotto lotto) {
        int matchCount = matchCount(lotto);
        if (matchCount < FIFTH_PRIZE_MATCHING_COUNT) {
            return LottoResult.NOTING;
        }
        if (matchCount == FIFTH_PRIZE_MATCHING_COUNT) {
            return LottoResult.FIFTH_PRIZE;
        }
        if (matchCount == FOURTH_PRIZE_MATCHING_COUNT) {
            return LottoResult.FOURTH_PRIZE;
        }
        if (matchCount == THIRD_PRIZE_MATCHING_COUNT) {
            return matchBonusNumber(lotto);
        }
        return LottoResult.FIRST_PRIZE;
    }
}

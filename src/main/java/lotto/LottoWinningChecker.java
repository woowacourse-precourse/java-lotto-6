package lotto;

import java.util.List;

public class LottoWinningChecker {
    private final List<LottoNumber> lottoResult;
    private final LottoNumber bonusNumber;

    LottoWinningChecker(List<Integer> lottoWinningNumber, Integer bonusNumber) {
        this.lottoResult = lottoWinningNumber.stream()
                .map(LottoNumber::new)
                .toList();

        this.bonusNumber = new LottoNumber(bonusNumber);
    }
    private int matchCount(Lotto lotto){
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoResult) {
            if (lotto.containLottoNumber(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }
    private LottoResult matchBonusNumber(Lotto lotto){
        if( lotto.containLottoNumber(bonusNumber) ){
            return LottoResult.SECOND_PRIZE;
        }
        return LottoResult.THIRD_PRIZE;
    }
    public LottoResult check(Lotto lotto) {
        int matchCount = matchCount(lotto);
        if (matchCount < 3) {
            return LottoResult.NOTING;
        }
        if (matchCount == 3) {
            return LottoResult.FIFTH_PRIZE;
        }
        if (matchCount == 4) {
            return LottoResult.FOURTH_PRIZE;
        }
        if (matchCount == 5) {
            return matchBonusNumber(lotto);
        }
        return LottoResult.FIRST_PRIZE;
    }
}

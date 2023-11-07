package lotto.domain;

import lotto.exception.lotto.BonusDuplicatedException;

public class WinLotto {

    private final Lotto numbers;
    private final LottoNumber bonus;

    public WinLotto(Lotto winLottoNumber, LottoNumber bonus) {
        validateDuplication(winLottoNumber, bonus);
        this.numbers = winLottoNumber;
        this.bonus = bonus;
    }
    public static WinLotto of(Lotto winLottoNumber, LottoNumber bonus) {
        return new WinLotto(winLottoNumber, bonus);
    }

    private void validateDuplication(Lotto winLottoNumber, LottoNumber bonus) {
        if(winLottoNumber.contains(bonus)){
            throw new BonusDuplicatedException(winLottoNumber, bonus);
        }
    }

    public Rank calculateRank(Lotto lotto) {
        int matchCount = numbers.countMatchedNumber(lotto);
        boolean matchBonus = lotto.contains(bonus);
        return Rank.valueOf(matchCount, matchBonus);
    }
}

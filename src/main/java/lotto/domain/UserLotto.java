package lotto.domain;

import lotto.Lotto;

public class UserLotto {

    private final Lotto lotto;
    private final LottoNumber bonusLottoNumber;

    private UserLotto(final Lotto lotto, final LottoNumber bonusLottoNumber) {
        validate(lotto, bonusLottoNumber);
        this.lotto = lotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static UserLotto from(final Lotto lotto, final LottoNumber bonusLottoNumber) {
        return new UserLotto(lotto, bonusLottoNumber);
    }

    private void validate(final Lotto lotto, final LottoNumber bonusLottoNumber) {
        validateDuplicate(lotto, bonusLottoNumber);
    }

    private void validateDuplicate(final Lotto lotto, final LottoNumber bonusLottoNumber) {
        if (lotto.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또와 보너스 번호가 서로 중복됩니다.");
        }
    }

    public Rank calculateRank(final Lotto other) {
        long matchCount = lotto.compare(other);
        boolean isBonus = other.contains(bonusLottoNumber);
        return Rank.findBy(matchCount, isBonus);
    }
}

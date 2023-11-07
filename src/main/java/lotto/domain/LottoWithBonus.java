package lotto.domain;

import lotto.exception.ExceptionMessage;

public class LottoWithBonus {
    private final Lotto userLotto;
    private final Bonus userBonus;

    private LottoWithBonus(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);
        this.userLotto = lotto;
        this.userBonus = bonus;
    }

    public static LottoWithBonus of(Lotto lotto, Bonus bonus) {
        return new LottoWithBonus(lotto, bonus);
    }

    private void validate(Lotto lotto, Bonus bonus) {
        if (lotto.getLotto()
                .stream()
                .filter(lottoNumber -> lottoNumber == bonus.getBonusNumber())
                .findFirst()
                .isPresent()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER.getErrorDescription());
        }
    }

    public int findSameNumberCount(Lotto generatedRandomLotto) {
        int sameLottoNumberCount = userLotto.findSameNumberCountInLotto(generatedRandomLotto);
        return sameLottoNumberCount;
    }

    public boolean isBonusInLotto(Lotto generatedRandomLotto) {
        return userBonus.hasSameNumberInGeneratedLotto(generatedRandomLotto);
    }
}

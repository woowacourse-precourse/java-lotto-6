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
        // 중복된 숫자가 존재하는지 확인한다
        if (lotto.getLotto()
                .stream()
                .filter(lottoNumber -> lottoNumber == bonus.getBonusNumber())
                .findFirst()
                .isPresent()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER.getErrorDescription());
        }
    }

    public int findSameNumberCount(Lotto generatedRandomLotto) {
        // 같은 숫자가 있는지만 확인하면 된다
        int sameLottoNumberCount = userLotto.findSameNumberCountInLotto(generatedRandomLotto);
        if (userBonus.hasSameNumberInLotto(generatedRandomLotto)) {
            return sameLottoNumberCount + 1;
        }
        return sameLottoNumberCount;
    }
}

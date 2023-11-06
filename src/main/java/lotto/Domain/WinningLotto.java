package lotto.Domain;

import java.util.Arrays;
import java.util.List;
import lotto.Domain.Validator.WinningLottoValidator;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, BonusNumber bonusNumber) {
        WinningLottoValidator.doValidate(winningLotto, bonusNumber);
    }

    public Rank getRankOf(Lotto lotto) {
        int hitCount = count(lotto);
        boolean isHitBonus = lotto.hasNumber(bonusNumber.getBounusNum());
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.hit(hitCount,isHitBonus))
                .findFirst()
                .orElse(Rank.NOTHING);
    }

    private int count(Lotto lotto) {
        int count = 0;
        for (int num : lotto.getNumbers()) {
            if (this.winningLotto.hasNumber(num)) {
                count++;
            }
        }
        return count;
    }
}

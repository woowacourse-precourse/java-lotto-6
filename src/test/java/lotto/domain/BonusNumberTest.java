package lotto.domain;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.global.constant.BonusNumberMatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberTest {

    BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        bonusNumber = new BonusNumber();
    }

    @Test
    void 당첨숫자가_5개일치하고_보너스_숫자도_맞는_경우_MATCH리턴하는지확인() {
        bonusNumber.generateBonusNumber("6");

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        BonusNumberMatch bonusNumberMatch = bonusNumber.compareBonusNumberWithLotto(lotto, 5);

        assertThat(bonusNumberMatch)
                .isEqualTo(BonusNumberMatch.MATCH);
    }

    @Test
    void 당첨숫자가_5개일치하고_보너스_숫자가_안_맞는경우_NOT_MATCH리턴하는지확인() {
        bonusNumber.generateBonusNumber("7");

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        BonusNumberMatch bonusNumberMatch = bonusNumber.compareBonusNumberWithLotto(lotto, 5);

        assertThat(bonusNumberMatch)
                .isEqualTo(BonusNumberMatch.NOT_MATCH);
    }

    @Test
    void 당첨숫자가_5개가_아닌경우_NOT_MATTER_리턴하는지확인() {
        bonusNumber.generateBonusNumber("7");

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        BonusNumberMatch bonusNumberMatch = bonusNumber.compareBonusNumberWithLotto(lotto, 3);

        assertThat(bonusNumberMatch)
                .isEqualTo(BonusNumberMatch.NOT_MATTER);
    }
}

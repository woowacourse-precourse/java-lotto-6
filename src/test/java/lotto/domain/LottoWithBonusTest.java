package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoWithBonus;
import org.junit.jupiter.api.Test;

public class LottoWithBonusTest {
    private Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    private LottoWithBonus lottoWithBonus;

    @Test
    void 보너스_범위가_벗어난_경우_예외() {
        assertThatThrownBy(
                () -> lottoWithBonus = new LottoWithBonus(lotto, new Bonus(46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위에서 벗어난");
    }

    @Test
    void 보너스_로또_중복된_경우_예외() {
        assertThatThrownBy(
                () -> lottoWithBonus = new LottoWithBonus(lotto, new Bonus(2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자를");
    }

    @Test
    void 보너스_로또_범위_내_그리고_서로_다른_수_성공() {
        assertThatCode(
                () -> lottoWithBonus = new LottoWithBonus(lotto, new Bonus(40))
        ).doesNotThrowAnyException();
    }

}

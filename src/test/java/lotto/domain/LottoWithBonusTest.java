package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoWithBonusTest {
    private Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
    private LottoWithBonus lottoWithBonus;

    @Test
    void 보너스_범위가_벗어난_경우_예외() {
        assertThatThrownBy(
                () -> lottoWithBonus = new LottoWithBonus(lotto, Bonus.from(46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위에서 벗어난");
    }

    @Test
    void 보너스_로또_중복된_경우_예외() {
        assertThatThrownBy(
                () -> lottoWithBonus = new LottoWithBonus(lotto, Bonus.from(2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자를");
    }

    @Test
    void 보너스_로또_범위_내_그리고_서로_다른_수_성공() {
        assertThatCode(
                () -> lottoWithBonus = new LottoWithBonus(lotto, Bonus.from(40))
        ).doesNotThrowAnyException();
    }

}

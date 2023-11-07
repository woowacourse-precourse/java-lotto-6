package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoWithBonusTest {
    private Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class unvalidLottoWithBonus {
        @Test
        void 보너스_범위가_벗어난_경우_예외() {
            assertThatThrownBy(
                    () -> LottoWithBonus.of(lotto, Bonus.of(46, lotto)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("범위에서 벗어난");
        }

        @Test
        void 보너스_로또_중복된_경우_예외() {
            assertThatThrownBy(
                    () -> LottoWithBonus.of(lotto, Bonus.of(2, lotto)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("중복된 숫자를");
        }
    }

    @Test
    void 보너스_로또_범위_내_그리고_서로_다른_수_성공() {
        assertThatCode(
                () -> LottoWithBonus.of(lotto, Bonus.of(40, lotto))
        ).doesNotThrowAnyException();
    }


}

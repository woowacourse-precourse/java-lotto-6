package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 보너스번호를_통해_보너스객체를_생성한다(int input) {
        // when
        Bonus result = Bonus.from(input);
        // then
        assertThat(result).isInstanceOf(Bonus.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 0, 46})
    void 보너스번호가_1_45이내가_아니라면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> Bonus.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, false"})
    void isSameNumber는_로또와_보너스번호가_같은지_판단한다(int bonusNumber, boolean isMatch) {
        //given
        Bonus bonus = Bonus.from(bonusNumber);
        Lotto lotto = Lotto.from(List.of(1, 3, 4, 5, 6, 7));
        // when
        boolean result = Bonus.isSameNumber(lotto, bonus);
        // then
        assertThat(result).isEqualTo(isMatch);
    }

}
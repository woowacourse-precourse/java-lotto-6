package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class InputValidationTest extends InputValidation{

    @Test
    void 숫자문자열을_숫자로_변환() {

        //given
        String money = "8000";

        //when
        int result = toInt(money);

        //then
        assertThat(result).isEqualTo(8000);
    }

    @Test
    void 입력문자열이_양수면_예외_발생_X() {

        //given
        String input = "8000";

        //when, then
        assertThatNoException().isThrownBy(() -> isPositiveNum(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ten", "1a", "a12", "0", "-1000"})
    void 입력문자열이_양수가_아닌_경우_예외처리(String input) {
        assertThatThrownBy(() -> isPositiveNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값은 0보다 큰 숫자여야 합니다.");
    }

    @Test
    void 입력값이_범위_밖이면_예외_발생() {
        assertThatThrownBy(() -> isWithinRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_리스트가_범위_밖이면_예외_발생() {

        //given
        List<Integer> input = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5));

        //when, then
        assertThatThrownBy(() -> isWithinRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_로또번호와_중복되면_예외_발생() {

        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when, then
        assertThatThrownBy(() -> isBonusDuplicateOfLotto(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_로또번호와_중복되지_않으면_예외_발생_X() {

        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //then, when
        assertThatNoException()
                .isThrownBy(() -> isBonusDuplicateOfLotto(lotto, 7));
    }

    @Test
    void 입력한_로또_번호가_중복되면_예외_발생() {

        //given
        List<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));

        //when, then
        assertThatThrownBy(() -> hasDuplicateNum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

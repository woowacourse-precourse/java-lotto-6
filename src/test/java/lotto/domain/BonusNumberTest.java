package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10, 45})
    void BonusNumber_객체_생성(int input) {
        assertThat(BonusNumber.create(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 50, 100, 1_000})
    void 보너스_번호가_허용범위를_넘어가면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> BonusNumber.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 46까지 입력하실 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100, -1_000})
    void 보너스_번호가_최소허용_범위보다_작으면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> BonusNumber.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1이상부터 입력하실 수 있습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "10,10", "25,25", "45,45"})
    void getNumber를_통해_로또_번호를_반환한다(int input, int expected) {
        assertThat(BonusNumber.create(input).getNumber())
                .isEqualTo(expected);
    }
}

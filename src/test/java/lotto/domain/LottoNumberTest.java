package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("로또 번호가 1보다 작거나 45보다 크면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void createLottoNumberByOutOfRange(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void createLottoNumber(int number) {

        LottoNumber lottoNumber = new LottoNumber(number);

        int actual = lottoNumber.getNumber();
        assertThat(actual).isEqualTo(number);
    }
}

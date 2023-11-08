package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @DisplayName("숫자를 입력하면 캐싱된 객체가 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void createFromCachedInstances(int number) {
        assertThat(LottoNumber.from(number)).isSameAs(LottoNumber.from(number));
    }

    @DisplayName("1과 45사이의 숫자를 입력하면 객체가 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void createByValidNumber(int number) {
        assertThat(LottoNumber.from(number)).isNotNull();
    }

    @DisplayName("1과 45사이를 벗어난 숫자를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void createByInvalidNumber(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

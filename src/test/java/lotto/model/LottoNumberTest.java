package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호는 1보다 작은 값을 가지면 예외를 발생한다.")
    void createNumber_NumberLessThan1_ThrownException() {
        // given
        int number = 0;

        // when
        // then
        assertThatThrownBy(() -> LottoNumber.of(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 45보다 큰 값을 가지면 예외를 발생한다.")
    void createNumber_NumberMoreThan45_ThrownException() {
        // given
        int number = 46;
        // when
        // then
        assertThatThrownBy(() -> LottoNumber.of(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10 , 20, 30, 45})
    @DisplayName("로또 번호는 1 ~ 45 사이의 값으로  이루어져있다.")
    void createLottoNumber(int number) {
        // given

        // when
        // then
        assertThat(LottoNumber.of(number)).isNotNull();
    }
}

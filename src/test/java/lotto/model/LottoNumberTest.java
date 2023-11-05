package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
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
        assertThatThrownBy(() -> LottoNumber.generateLottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 45보다 큰 값을 가지면 예외를 발생한다.")
    void createNumber_NumberMoreThan45_ThrownException() {
        // given
        int number = 46;
        // when
        // then
        assertThatThrownBy(() -> LottoNumber.generateLottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10 , 20, 30, 45})
    @DisplayName("로또 번호는 1 ~ 45 사이의 값으로 이루어져있다.")
    void generateLottoNumber(int number) {
        // given

        // when
        // then
        assertThat(LottoNumber.generateLottoNumber(number))
                .isNotNull();
    }

    @Test
    @DisplayName("로또 사이즈만큼 로또 번호를 생성한다.")
    void generateLottoNumbers() {
        // given
        int lottoSize = 6;

        // when
        List<LottoNumber> lottoNumbers = LottoNumber.generateLottoNumbers(lottoSize);

        // then
        assertAll(
                () -> assertThat(lottoNumbers).isNotEmpty(),
                () -> assertThat(lottoNumbers).hasSize(lottoSize),
                () -> assertThat(lottoNumbers).doesNotHaveDuplicates()
        );
    }
}

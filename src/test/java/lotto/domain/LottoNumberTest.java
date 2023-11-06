package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 24, 45})
    @DisplayName("번호가 1-45 사이에 존재하면 번호가 생성된다.")
    void createNumberInRightRange(int number) {
        //given
        //when
        LottoNumber lottoNumber = new LottoNumber(number);
        //then
        assertThat(lottoNumber).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("번호가 범위 밖에 있으면 예외가 발생한다.")
    void createNumberOverRange(int number) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1과 45사이의 숫자만 번호로 등록 가능 합니다.\n");
    }
}
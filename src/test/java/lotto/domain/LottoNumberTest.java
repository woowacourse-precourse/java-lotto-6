package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 24, 45})
    @DisplayName("성공 - 올바른 범위 내의 번호 생성")
    void right_Range(int number) {
        //given
        //when
        LottoNumber lottoNumber = new LottoNumber(number);
        //then
        assertThat(lottoNumber).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("실패 - 범위 외의 번호 생성")
    void out_Of_Range(int number) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1과 45사이의 숫자만 번호로 등록 가능 합니다.\n");
    }
}
package lotto.domain;

import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("로또 번호 입력 값이 빈 값 또는 숫자가 아닌 경우에 대한 예외 검증")
    @ValueSource(strings = {"", "kyj", "5j"})
    @ParameterizedTest
    void LottoNumber1(String input){
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> new LottoNumber(input));

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 번호 범위를 벗어나는 경우에 대한 예외 검증")
    @ValueSource(strings = {"0", "50", "-123"})
    @ParameterizedTest
    void outOfLottoNumberRange(String input){
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> new LottoNumber(input));

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

}
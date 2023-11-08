package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {





    @DisplayName("LottoNumber 정상 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,45,25})
    void ofTest(int input){
        assertThatNoException().isThrownBy(() -> LottoNumber.of(input));
    }

    @DisplayName("동등 객체 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,45,25})
    void equalsTest(int input){
        LottoNumber lottoNumber1 = LottoNumber.of(input);
        LottoNumber lottoNumber2 = LottoNumber.of(input);

        assertThat(lottoNumber1.equals(lottoNumber2)).isTrue();
    }

    @DisplayName("범위 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0,46,-1})
    void validateTest(int input){
        assertThatThrownBy(() ->LottoNumber.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자의 범위는 1이상 45이하여야 합니다");
    }

}
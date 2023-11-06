package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @DisplayName("1~45 사이의 로또 번호를 생성했을 때, 같은 번호를 가지면 같은 객체로 판단 가능한지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 25, 45})
    void compareLottoNumber(int number) {
        // given, when
        LottoNumber lottoNumber = new LottoNumber(number);
        LottoNumber sameLottoNumber = new LottoNumber(number);
        // then
        assertThat(lottoNumber).isEqualTo(sameLottoNumber);
    }

    @DisplayName("1~45 이외의 로또를 생성할 때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 46, 100})
    void createInvalidLottoNumber(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getWithFormatAndPrefix(1, 45));
    }
}
package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.exception.LottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[단위 테스트] 로또 번호")
class LottoNumberTest {

    @DisplayName("정상 상황일 때 로또 번호가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 45})
    void create_lottoNumber(int input) {
        // when
        LottoNumber lottoNumber = new LottoNumber(input);

        // then
        assertAll(
                () -> assertThatCode(() -> new LottoNumber(input)).doesNotThrowAnyException(),
                () -> assertThat(lottoNumber).isNotNull()
        );
    }

    @DisplayName("숫자 범위가 1~45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void throw_exception_when_invalid_range(int input) {
        // when & then
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoNumberException.INVALID_RANGE.getMessage());
    }
}

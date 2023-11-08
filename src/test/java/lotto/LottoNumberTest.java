package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 번호 테스트")
class LottoNumberTest {
    private static final String ERROR_INTEGER_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다.";
    private static final String ERROR_RANGE_MESSAGE = "[ERROR] 로또 번호는 1이상 45이하 입니다.";

    @DisplayName("로또 번호는 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1sd0", "asdjkl;.,"})
    void lottoNumberNotDigit(String lottoNumber) {
        assertThatThrownBy(() -> new LottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INTEGER_MESSAGE);
    }

    @DisplayName("로또 번호는 1 이상 45 이하 가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1111", "46", "100000"})
    void lottoNumberInvalidRange(String lottoNumber) {
        assertThatThrownBy(() -> new LottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_RANGE_MESSAGE);
    }
}

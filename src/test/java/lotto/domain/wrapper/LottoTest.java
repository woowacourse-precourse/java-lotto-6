package lotto.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.handler.ErrorHandler.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호에 숫자로 변환될 수 없는 타입이 들어가면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"1,2,3,4,5,육", "1,2,3,4,5,^", "1,2,3,4,5, ", "1,2,3,4,5,@"})
    void createLottoByInconvertibleType(String inputValue) {
        assertThatThrownBy(() -> Lotto.from(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INCONVERTIBLE_TYPE.getException().getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개 보다 적거나 많다면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"1,2,3,4,5,6,7,8,9", "1,2,3,4,5,6,7", "1,2,3,4,5", "1,2,3"})
    void createLottoByInvalidSize(String inputValue) {
        assertThatThrownBy(() -> Lotto.from(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_SIZE.getException().getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,5,5,5", "1,2,3,3,3,3"})
    void createLottoByDuplicatedNumber(String inputValue) {
        assertThatThrownBy(() -> Lotto.from(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBER.getException().getMessage());
    }

    @DisplayName("로또 번호가 1 ~ 45 사이의 범위가 아니라면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"1,2,3,4,5,56", "-1,2,3,4,5,6", "0,2,3,4,5,6"})
    void createLottoByInvalidRange(String inputValue) {
        assertThatThrownBy(() -> Lotto.from(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE.getException().getMessage());
    }
}
package lotto.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberInputManagerTest {

    @DisplayName("로또 당첨 번호 입력 포맷 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1,2,3,4,5,6 ", ",1,2,3,4,5,6", "1,2,3,4,5,6,", "a,1,2,3,4,5", "1,2,3, 4,5,6"})
    void inputIsNotAnswerNumber(String input) {
        assertThatThrownBy(() -> LottoNumberInputManager.fromString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WRONG_LOTTO_NUMBER_INPUT);
    }

    @DisplayName("로또 당첨 번호 크기 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5", "12233333333333,1,2,3,4,5"})
    void wrongLottoNumberSizeTest(String input) {
        assertThatThrownBy(() -> LottoNumberInputManager.fromString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WRONG_LOTTO_NUMBER_SIZE);
    }
}
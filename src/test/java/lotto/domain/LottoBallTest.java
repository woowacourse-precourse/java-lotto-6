package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoBallTest {

    @DisplayName("validateEmptyFromLottoBall() : 로또 볼 숫자가 지워진 경우")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void validateEmptyFromLottoBall_Fail(String amount) throws Exception {
        //given
        String exceptionMessage = "[ERROR] 로또 공에 숫자를 입력해주세요.";

        //when //then
        assertThatThrownBy(() -> new LottoBall(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }

    @DisplayName("validateCharacterFromLottoBall() : 로또 볼에 문자가 들어가는 경우")
    @ParameterizedTest
    @ValueSource(strings = {" ", "q1", "1e3"})
    void validateCharacterFromLottoBall_Fail(String amount) throws Exception {
        //given
        String exceptionMessage = "[ERROR] 로또 공에는 숫자만 입력 가능합니다.";

        //when //then
        assertThatThrownBy(() -> new LottoBall(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }

    @DisplayName("validateRangeFromLottoBall() : 로또 볼이 1미만 45이상의 수인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void validateRangeFromAmount_Fail(String amount) throws Exception {
        //given
        String exceptionMessage = "[ERROR] 로또 공은 1~45 사이의 숫자만 입력해주세요.";

        //when //then
        assertThatThrownBy(() -> new LottoBall(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }

}
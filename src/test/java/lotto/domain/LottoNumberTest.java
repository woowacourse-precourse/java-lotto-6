package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @ParameterizedTest(name = "입력 값: {0}")
    @DisplayName("로또 숫자를 생성할 때 숫자가 아닌 경우에는 예외가 발생한다")
    @ValueSource(strings = {"일", "사십삼", "43ㄴ"})
    public void should_throwException_when_notInteger(String input) {
        assertThatThrownBy(() -> LottoNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_INTEGER.getMessage());
    }

    @ParameterizedTest(name = "생성된 숫자: {0}")
    @DisplayName("로또 숫자를 생성할 때, 범위가 1 이상 45 이하가 아닌 경우에는 예외가 발생한다")
    @ValueSource(strings = {"0", "46"})
    public void should_throwException_when_invalidRange(String input) {
        assertThatThrownBy(() -> LottoNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_LOTTO_RANGE.getMessage());
    }

    @Test
    @DisplayName("두 LottoNumber 객체가 있을 때, number 필드를 이용하여 비교할 수 있다.")
    public void should_compare_betweenTwoInstance() {
        //given
        LottoNumber lottoNumber = LottoNumber.from("10");
        LottoNumber target = LottoNumber.from("10");

        //when
        boolean isSame = lottoNumber.equals(target);

        //then
        assertThat(isSame).isTrue();
    }
}
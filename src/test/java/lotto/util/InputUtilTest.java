package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputUtilTest {
    @Test
    @DisplayName("사용자가 숫자를 입력 시, 숫자가 아닌 값을 입력할 경우 예외가 발생한다.")
    public void inputMoneyTypeExceptionTest() throws Exception {
        // given
        String input = "1000j";
        // when
        // then
        Assertions.assertThatThrownBy(() -> InputUtil.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("숫자를 입력받을 때, 공백만 입력하면 예외가 발생한다.")
    public void inputSpaceExceptionTest() throws Exception {
        // given
        String input = " ";

        // when


        // then
        Assertions.assertThatThrownBy(() -> InputUtil.checkContainSpace(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백을 제외하고 입력해주세요.");

    }

    @Test
    @DisplayName("숫자들을 입력받을 때, 마지막 문자열이 ,이면 예외가 발생한다.")
    public void inputLastStringCommaCheckTest() throws Exception {
        // given
        String input = "1,2,3,4,5,";

        // when


        // then
        Assertions.assertThatThrownBy(() -> InputUtil.checkContainComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 입력방식입니다.");
    }
}

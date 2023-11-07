package lotto.service;

import static lotto.settings.ErrorMessage.CONTAIN_SPACE;
import static lotto.settings.ErrorMessage.HAS_COMMA_ON_BOTH_SIDES;
import static lotto.settings.ErrorMessage.INVALID_NUMBER_FORMAT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateTest {
    @Test
    @DisplayName("사용자는 공백을 입력하면 예외가 발생한다.")
    void validateTrim() {
        // given
        String[] spaces= {" a", "a b", "a "};

        // when  // then
        for (String space : spaces) {
            assertThatThrownBy(()-> Validate.trim(space))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(CONTAIN_SPACE.getMessage());
        }
    }

    @Test
    @DisplayName("사용자가 문자를 입력하면 예외가 발생한다.")
    void ValidateNumber() {
        // given
        String[] strings= {"j","j20","2j0","20j"};

        // when  // then
        // 배열을 하나씩 확인
        for (String string : strings) {
            assertThatThrownBy(() -> Validate.number(string))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_NUMBER_FORMAT.getMessage());
        }
        //배열을 한꺼번에 확인
        assertThatThrownBy(() -> Validate.number(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("사용자가 문자열을 입력할 때 양끝에 ,를 두면 예외가 발생한다.")
    void ValidateCommaBeforeAndAfter() {
        // given
        String[] inputs = {",1,2", "1,2,", ",1,2,3,"};
        // when
        for (String input : inputs) {
            String[] splitInput = input.split(",", -1);

            // then
            assertThatThrownBy(() -> Validate.commaBeforeAndAfter(splitInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(HAS_COMMA_ON_BOTH_SIDES.getMessage());
        }
    }
}
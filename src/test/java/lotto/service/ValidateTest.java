package lotto.service;

import static lotto.settings.ErrorMessage.CONTAIN_SPACE;
import static lotto.settings.ErrorMessage.HAS_COMMA_ON_BOTH_SIDES;
import static lotto.settings.ErrorMessage.INVALID_NUMBER_FORMAT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidateTest {
    @DisplayName("사용자가 공백을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" a", "a b", "a "})
    void validateTrim(String containsSpace) {
        assertThatThrownBy(()-> Validate.trim(containsSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CONTAIN_SPACE.getMessage());
    }

    @DisplayName("사용자가 문자를 입력하면 예외가 발생한다.")
    @Test
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

    @DisplayName("사용자가 문자열 양끝에 ,를 두면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {",1,2", "1,2,", ",1,2,3,"})
    void ValidateCommaBeforeAndAfter(String input) {
        // when
        String[] splitInput = input.split(",", -1);

        // then
        assertThatThrownBy(() -> Validate.commaBeforeAndAfter(splitInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(HAS_COMMA_ON_BOTH_SIDES.getMessage());
    }
}
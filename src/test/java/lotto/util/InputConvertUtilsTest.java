package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.constants.ErrorMessage.HAVE_TO_INPUT_ONLY_NUMBER_AND_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputConvertUtilsTest {

    @DisplayName("입력 문자열 숫자 변환")
    @Test
    public void validateHasInput_exception_emptyInput() {
        //when
        String input = "3,4,5";
        List<Integer> numbers = InputConvertUtils.lottoNumbersToIntegerList(input);

        //then
        assertThat(numbers).contains(3, 4, 5);
    }

    @DisplayName("입력 문자열 숫자 변환 예외 : 입력받은 문자열을 숫자로 변환할 수 없으면 IllegalArgumentException을 발생")
    @ParameterizedTest
    @ValueSource(strings = {"3  ,1,1", "가,1,3", "3,가,5", "", "  ", "\n"})
    public void validateHasInput_exception_emptyInput(String input) {
        // when, then
        assertThatThrownBy(() ->
                InputConvertUtils.lottoNumbersToIntegerList(input)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(HAVE_TO_INPUT_ONLY_NUMBER_AND_DELIMITER.getMessage());
    }
}

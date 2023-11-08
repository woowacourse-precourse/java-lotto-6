package lotto.validate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {
    InputValidation inputValidation = new InputValidation();

    @ParameterizedTest
    @DisplayName("숫자 사이의 공백, null 테스트")
    @ValueSource(strings = {"", " ", " 1 \n \t"})
    void isNullOrBlank(String input) {
        assertThatThrownBy(() -> inputValidation.isNullOrBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈 값을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("당첨 번호 중복 테스트")
    void isDuplicate() {
        assertThatThrownBy(() -> inputValidation.isDuplicate(List.of(1,2,3,3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 번호를 입력할 수 없습니다.");
    }

}
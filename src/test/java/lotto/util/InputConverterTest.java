package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputConverterTest {
    @DisplayName("잘못된 형식의 로또 번호가 입력됐을 때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,4,5,6", "1,2,3,4,5,6,", ",1,2,3,4,5,6,", "1,,2,3,4,5,6" , "1,2, ,3,4,5,6", "1,2,3,4,,6", "1, , ,4"})
    void convertToList(String input) {
        Assertions.assertThatThrownBy(() -> InputConverter.convertToList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumbersTest {

    @ParameterizedTest
    @DisplayName("당첨번호 입력 시 쉼표가 연속해서 있으면 예외가 발생한다.")
    @CsvSource({
            "1,,2,3,4,5,6,7",
            "1,2,3,4,,5,6,7",
            "1,2,3,4,5,6,,7"
    })
    void testConsecutiveCommasInInput(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(Collections.singletonList(input)));
    }

    @ParameterizedTest
    @DisplayName("당첨번호 입력 시 쉼표를 제외한 특수문자를 입력하면 예외가 발생한다.")
    @CsvSource({
            "1,2,3,4!5,6",
            "1,2,3~4,5,6",
            "1@2,3,4,5,6"
    })
    void testSpecialCharactersInInput(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(Collections.singletonList(input)));
    }
}
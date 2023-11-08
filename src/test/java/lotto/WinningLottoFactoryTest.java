package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.domain.WinningLottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoFactoryTest {
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 정수만 입력하세요.";

    @DisplayName("정수가 아닌 값을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000j", "abc", "#"})
    void meetsInputFormat(String input) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> WinningLottoFactory.of(input));

        assertTrue(thrown.getMessage().equals(NUMBER_FORMAT_ERROR));
    }
}
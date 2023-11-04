package lotto.engine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class GameEngineValidatorTest {
    private GameEngineValidator gameEngineValidator;

    private static String[] 숫자가_아닌경우() {
        return new String[]{null, "", " ", "1q", "qwe", "1o", "★", "!", "Q", "*", "+"};
    }

    @BeforeEach
    void setUp() {
        gameEngineValidator = new GameEngineValidator();
    }


    @ParameterizedTest
    @MethodSource("숫자가_아닌경우")
    void 가격은_숫자가_아니면_예외가나온다(String price) {
        Assertions.assertThatCode(() -> gameEngineValidator.checkPrice(price))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 숫자가 아닙니다.", price));
    }

    @ParameterizedTest
    @CsvSource({"-1", "0", "-21474836", "-2147484000", "-9223372036854775000"})
    void 가격은_양수가_아니면_예외가나온다(String price) {
        Assertions.assertThatCode(() -> gameEngineValidator.checkPrice(price))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 양수가 아닙니다.", price));
    }

    @ParameterizedTest
    @CsvSource({"2147483647", "2147483648", "9223372036854775807", "999", "10", "1", "9", "101", "999", "1001"})
    void 가격은_천의배수가_아니면_예외가나온다(String price) {
        Assertions.assertThatCode(() -> gameEngineValidator.checkPrice(price))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 천의 배수가 아닙니다.", price));
    }

    @ParameterizedTest
    @CsvSource({"2147483000", "2147484000", "9223372036854775000", "1000", "10000", "9000", "7000", "123456789000"})
    void 가격은_천의배수인_양수이면_예외가나오지_않는다(String price) {
        Assertions.assertThatCode(() -> gameEngineValidator.checkPrice(price))
                .doesNotThrowAnyException();
    }
}
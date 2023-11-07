package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.validator.LottoValidator;
import lotto.domain.validator.WinnerNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinnerNumberValidatorTest {
    public static WinnerNumberValidator winnerNumberValidator;
    public static LottoValidator lottoValidator;

    private static Stream<Arguments> testNumbersForValidateNumeric() {
        return Stream.of(
                arguments(Arrays.asList("1", " ", "  3", "4", "5")),
                arguments(Arrays.asList("하나", "둘", "셋", "넷", "다섯", "여섯")),
                arguments(Arrays.asList("1", "bb", "cc", "dd", "ee", "ff"))
        );
    }

    @BeforeEach
    public void setUp() {
        winnerNumberValidator = new WinnerNumberValidator();
        lottoValidator = new LottoValidator();
    }

    @DisplayName("입력한 당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("testNumbersForValidateNumeric")
    public void testValidateNumeric(List<String> winnerNumber) {
        assertThatThrownBy(() -> winnerNumberValidator.validateNumeric(winnerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

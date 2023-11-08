package lotto.Service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoInitService 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoInitServiceTest {
    private static final LottoInitService service = new LottoInitService();

    @ParameterizedTest
    @CsvSource(value = {"1000,1000", "23000,23000", "45000,45000", "420000,420000", "9999000,9999000"})
    void 올바른_입력값을_숫자로_변환한다(String input, Integer expected) {
        Integer actualValue = service.inputAmountToNumber(input);
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1213", "10000000000000000", "10000000", "1,000", "1 11"})
    void 잘못된_입력값은_예외를_반환한다(String input) {
        assertThatThrownBy(() -> service.inputAmountToNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

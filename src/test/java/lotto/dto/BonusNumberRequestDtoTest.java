package lotto.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberRequestDtoTest {

    @ValueSource(strings = {"abc", "일", ""})
    @ParameterizedTest
    void validateNumberFormatTest(String input) {
        Assertions.assertThatThrownBy(() -> new BonusNumberRequestDto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

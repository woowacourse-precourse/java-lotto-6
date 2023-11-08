package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "20", "45"})
    void create_유효한_값(String input) {
        BonusNumber.create(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "0", "46", "-10"})
    void create_유효하지_않은_값(String input) {
        assertThatThrownBy(() -> BonusNumber.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
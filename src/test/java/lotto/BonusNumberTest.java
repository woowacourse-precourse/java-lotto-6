package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"d", " ", "\n"})
    void 보너스번호_숫자아닌값_예외처리_테스트(String input) {
        assertThatThrownBy(() -> new BonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"46", "0"})
    void 보너스번호_범위밖인값_예외처리_테스트(String input) {
        assertThatThrownBy(() -> new BonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }
}

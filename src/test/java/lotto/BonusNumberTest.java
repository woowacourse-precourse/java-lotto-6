package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {46, 0})
    void 보너스번호_범위밖인값_예외처리_테스트(int input) {
        assertThatThrownBy(() -> new BonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }
}

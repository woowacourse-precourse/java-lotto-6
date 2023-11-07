package lotto.domain.UtilityTest;

import lotto.domain.Model.Lotto;
import lotto.domain.Utility.Constant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConstantTest {
    @DisplayName("Constant 클래스를 인스턴스화 하려고 하면 예외가 발생한다.")
    @Test
    void createConstantClass() {
        assertThatThrownBy(() -> new Constant())
                .isInstanceOf(AssertionError.class);
    }
}

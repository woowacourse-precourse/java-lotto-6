package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("금액 검증 확")
    void newLotto() {
        assertThatThrownBy(() ->  new LottoGenerator(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
package lotto.domain.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    @DisplayName("보너스 넘버가 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void createBonusByNotNumber() {
        assertThatThrownBy(() -> new BonusNumber("aa"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
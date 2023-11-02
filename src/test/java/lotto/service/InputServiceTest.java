package lotto.service;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputServiceTest {
    @DisplayName("로또 구매금액이 1000의 배수가 아니라면 예외가 발생한다.")
    @Test
    void 로또_구매금액_예외처리_검증() {
        InputService inputService = new InputService();
        int invalidAmount = 1010;

        assertThrows(IllegalArgumentException.class, () -> {
            inputService.validateMultipleOfThousand(invalidAmount);
        });
    }
}
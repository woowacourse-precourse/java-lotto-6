package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.controller.BonusNumberHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BonusNumberHandlerTest {
    private BonusNumberHandler handler;

    @BeforeEach
    void setUp() {
        handler = new BonusNumberHandler("42");
    }

    @Test
    void testHandle_ValidBonusNumber() {
        handler.handle();
    }

    @Test
    void testHandle_InvalidBonusNumber() {
        handler = new BonusNumberHandler("100");
        assertThatThrownBy(() -> handler.handle())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testGetHandledResult() {
        Integer result = handler.getHandledResult();
        assertThat(result).isEqualTo(42);
    }
}
package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinningResultTest {
    @Test
    void create() {
        WinningResult winningResult = WinningResult.create();

        assertThat(winningResult)
                .isInstanceOf(WinningResult.class);
    }
}
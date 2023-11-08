package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WinningNumbersTest {

    @Test
    void testGetBonusNumber() {
        assertThat(new WinningNumbers(Arrays.asList(1, 3, 5, 7, 8, 11), 12).getBonusNumber())
                .isEqualTo(12);
    }
}
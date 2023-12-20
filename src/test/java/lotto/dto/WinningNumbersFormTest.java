package lotto.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningNumbersFormTest {

    @Test
    void validateNumbersFormatTest() {
        String[] input = {"1, 2, 3, 4, 5, 가"};

        Assertions.assertThatThrownBy(() -> new WinningNumbersForm(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

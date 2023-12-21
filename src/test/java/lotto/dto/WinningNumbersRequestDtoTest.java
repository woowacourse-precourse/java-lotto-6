package lotto.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningNumbersRequestDtoTest {

    @Test
    void validateNumbersFormatTest() {
        String input = "1, 2, 3, 4, 5, 가";

        Assertions.assertThatThrownBy(() -> new WinningNumbersRequestDto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

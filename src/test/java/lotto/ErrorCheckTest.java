package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ErrorCheckTest {
    @DisplayName("당첨 번호의 크기가 6이 아니면 에러가 발생해야 한다.")
    @Test
    void checkErrorOccurWinningNumbersSize() {
        String[] invalidWinningNumbers = {"1", "2", "3", "4"};
        assertThatThrownBy(() -> ErrorCheck.validateWinningNumbersSize(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
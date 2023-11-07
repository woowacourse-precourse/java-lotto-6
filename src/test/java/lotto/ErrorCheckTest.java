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

    @DisplayName("당첨 번호로 숫자 이외의 값(알파벳)을 입력하면 에러가 발생해야 한다.")
    @Test
    void checkErrorOccurWinningNumbersDataAlphabet() {
        String[] invalidWinningNumbers = {"1", "2", "3", "a", "5", "6"};
        assertThatThrownBy(() -> ErrorCheck.validateWinningNumbersDataType(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호로 숫자 이외의 값을 입력하면 에러가 발생해야 한다.")
    @Test
    void checkErrorOccurWinningNumbersData() {
        String[] invalidWinningNumbers = {"1", "2", "3", ".", "5", "6"};
        assertThatThrownBy(() -> ErrorCheck.validateWinningNumbersDataType(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
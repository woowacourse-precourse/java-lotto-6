package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import lotto.constants.Messages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputProcessorTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("구매금액을 입력한 뒤 유효성 검사를 할때 예외가 발생한다.")
    @Test
    void testInvalidPurchaseAmountInput() {
        String input = "asd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> InputProcessor.processPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_INVALID_NUMERIC_INPUT);
    }

    @DisplayName("구매금액을 입력한 뒤 유효성 검사 후 숫자로 변환한다.")
    @Test
    void testValidPurchaseAmountInput() {
        String input = "1000";
        int expectedValue = 1000;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(InputProcessor.processPurchaseAmount()).isEqualTo(expectedValue);
    }

    @DisplayName("당첨번호를 입력한 뒤 유효성 검사에서 예외가 발생한다.")
    @Test
    void testInvalidWinningNumbersInput() {
        String input = "12,1,ㅁ,5,b,14";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> InputProcessor.processWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_INVALID_NUMERIC_INPUT);
    }

    @DisplayName("당첨번호를 입력한 뒤 유효성 검사 후 숫자리스트로 변환한다.")
    @Test
    void testValidWinningNumbersInput() {
        String input = "12,1,3,5,43,14";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Integer> expectedValue = Arrays.asList(12, 1, 3, 5, 43, 14);
        assertThat(InputProcessor.processWinningNumbers()).isEqualTo(expectedValue);
    }

    @DisplayName("보너스번호를 입력한 뒤 유효성 검사에서 예외가 발생한다.")
    @Test
    void testInvalidBonusNumberInput() {
        String input = "asd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> InputProcessor.processBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_INVALID_NUMERIC_INPUT);
    }

    @DisplayName("보너스번호를 입력한 뒤 유효성 검사 후 숫자로 변환한다.")
    @Test
    void testValidBonusNumberInput() {
        String input = "12";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int expectedValue = 12;
        assertThat(InputProcessor.processBonusNumber()).isEqualTo(expectedValue);
    }
}

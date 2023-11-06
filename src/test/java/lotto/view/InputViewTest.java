package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @BeforeEach
    void resetBuffer() {
        Console.close();
    }

    @Test
    @DisplayName("구입금액을 입력받는다.")
    void getPurchaseAmount() {
        setInput("8000");
        InputView.getPurchaseAmount();
    }

    @Test
    @DisplayName("구입금액이 정수가 아니면 예외를 발생한다.")
    void getPurchaseAmountWithNotInteger() {
        setInput("팔천원");
        assertThatThrownBy(() -> InputView.getPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입금액이 정수가 아니면 예외를 발생한다.")
    void getPurchaseAmountWithNotPositiveInteger() {
        setInput("-2000");
        assertThatThrownBy(() -> InputView.getPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 숫자를 입력한다.")
    void getWinningNumbers() {
        setInput("1,2,3,4,5,6");
        assertThat(InputView.getWinningNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 숫자 입력의 공백을 제거한다.")
    void getWinningNumbersWithBlanks() {
        setInput("1, 2, 3, 4, 5, 6");
        assertThat(InputView.getWinningNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 숫자는 정수만 입력할 수 있다.")
    void getWinningNumbersWithNotInteger() {
        setInput("1,2,3,4,5,육");
        assertThatThrownBy(() -> InputView.getWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("콤마는 연속으로 입력할 수 없다.")
    void getWinningNumbersWithDuplicatedComma() {
        setInput("1,2,3,,4,5,6");
        assertThatThrownBy(() -> InputView.getWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력은 콤마로 끝낼 수 없다.")
    void getWinningNumbersWithFinalComma() {
        setInput("1,2,3,4,5,6,");
        assertThatThrownBy(() -> InputView.getWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정수는 6개만 입력할 수 있다.")
    void getWinningNumbersWithNotSixIntegers() {
        setInput("1,2,3,4,5,6,7");
        assertThatThrownBy(() -> InputView.getWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호는 한 개의 정수만 입력할 수 있다.")
    void getBonusNumbersWithInvalidInput() {
        setInput("1,2");
        assertThatThrownBy(() -> InputView.getBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("양의 정수만 입력할 수 있다.")
    void getBonusNumbersWithNegativeInteger() {
        setInput("-12");
        assertThatThrownBy(() -> InputView.getBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void setInput(String input) {
        final byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
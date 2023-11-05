package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.TestConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.List;

public class InputViewTest {
    private final InputView inputView = TestConstant.testLottoConfig.inputView();

    @DisplayName("숫자가 아닌 문자열을 입력하면 예외가 발생한다.")
    @Test
    void readIntLineByNotInt() {
        setConsoleInput("가");

        assertThatThrownBy(() -> inputView.readIntLine())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자를 입력한다.")
    @Test
    void readIntLine() {
        setConsoleInput("1");

        int number = inputView.readIntLine();

        assertThat(number).isEqualTo(1);
    }

    @DisplayName("숫자 앞 뒤의 공백은 무시한다.")
    @Test
    void readIntLineByIntWithWhiteSpace() {
        setConsoleInput("  1  ");

        int number = inputView.readIntLine();

        assertThat(number).isEqualTo(1);
    }

    @DisplayName("숫자 여러 개를 입력한다.")
    @Test
    void readMultipleIntLine() {
        setConsoleInput("1", "1,2,3,4,5,6");

        List<Integer> numbers1 = inputView.readMultipleIntLine();
        List<Integer> numbers2 = inputView.readMultipleIntLine();

        assertThat(numbers1).isEqualTo(List.of(1));
        assertThat(numbers2).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("숫자 앞 뒤의 공백은 무시한다.")
    @Test
    void readMultipleIntLineByMultipleIntWithWhiteSpace() {
        setConsoleInput("  1  ,2,3");

        List<Integer> numbers = inputView.readMultipleIntLine();

        assertThat(numbers).isEqualTo(List.of(1, 2, 3));
    }

    @DisplayName("숫자 혹은 숫자 여러 개가 아닌 문자열을 입력하면 예외가 발생한다.")
    @Test
    void readMultipleIntLineByMultipleNotInt() {
        setConsoleInput("가,나,다");

        assertThatThrownBy(() -> inputView.readMultipleIntLine())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 문자열을 입력하면 예외가 발생한다.")
    @Test
    void readMultipleIntLineBlank() {
        setConsoleInput(" ");

        assertThatThrownBy(() -> inputView.readMultipleIntLine())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void setConsoleInput(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}

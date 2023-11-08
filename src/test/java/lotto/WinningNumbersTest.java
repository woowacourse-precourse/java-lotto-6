package lotto;

import lotto.Domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    @DisplayName("빈 문자를 입력할 경우 예외가 발생한다")
    @Test
    void createInputEmptyString() {
        assertThatThrownBy(() -> Parser.parseWinningNumbers("1,2,3,4,,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수만 입력할 수 있습니다.\n");
    }
    @DisplayName("쉼표(,)로 끝나도록 입력할 경우 예외가 발생한다")
    @Test
    void createInputLastComma() {
        assertThatThrownBy(() -> Parser.parseWinningNumbers("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수만 입력할 수 있습니다.\n");
    }
    @DisplayName("정수 외 다른 문자를 입력할 경우 예외가 발생한다")
    @Test
    void createInputWinningNumberNotInteger() {
        assertThatThrownBy(() -> Parser.parseWinningNumbers("1,2,3,4d,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수만 입력할 수 있습니다.\n");
    }
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void createResultNumbersByOverSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Error] 쉼표(,)로 구분했을 때 6개의 정수로 이루어져야 합니다.\n");
    }

    @DisplayName("당첨 번호의 개수가 6개 미만이면 예외가 발생한다")
    @Test
    void createResultNumbersByUnderSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Error] 쉼표(,)로 구분했을 때 6개의 정수로 이루어져야 합니다.\n");
    }

    @DisplayName("당첨 번호에 45보다 큰 정수가 있으면 예외가 발생한다.")
    @Test
    void createResultNumbersByOverOfRange() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 48, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이의 정수만 입력할 수 있습니다.\n");
    }

    @DisplayName("당첨 번호에 1보다 작은 정수가 있으면 예외가 발생한다.")
    @Test
    void createResultNumbersByUnderOfRange() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 0, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이의 정수만 입력할 수 있습니다.\n");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createResultNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 있습니다.\n");
    }
}

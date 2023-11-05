package lotto;

import lotto.Domain.Lotto;

import lotto.Domain.ResultNumbers;
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
        assertThatThrownBy(() -> new ResultNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Error] 쉼표(,)로 구분했을 때 6개의 정수로 이루어져야 합니다.\n");
    }

    @DisplayName("당첨 번호의 개수가 6개 미만이면 예외가 발생한다")
    @Test
    void createResultNumbersByUnderSize() {
        assertThatThrownBy(() -> new ResultNumbers(List.of(1, 2, 3, 4, 5), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Error] 쉼표(,)로 구분했을 때 6개의 정수로 이루어져야 합니다.\n");
    }

    @DisplayName("당첨 번호에 1~45 사이를 벗어나는 정수가 있으면 예외가 발생한다.")
    @Test
    void createResultNumbersByOutOfRange() {
        assertThatThrownBy(() -> new ResultNumbers(List.of(1, 2, 3, 48, 5, 6), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이의 정수만 입력할 수 있습니다.\n");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createResultNumbersByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new ResultNumbers(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 있습니다.\n");
    }

    @DisplayName("당첨 번호에 있는 숫자를 보너스 번호로 입력하면 예외가 발생한다")
    @Test
    void createResultNumbersByContainBonusNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new ResultNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 없는 정수를 입력해야 합니다.\n");
    }
}

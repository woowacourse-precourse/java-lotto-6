package lotto;

import lotto.exception.CustomizedException;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.model.Lotto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있는 경우 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    @DisplayName("로또 번호에 1부터 45의 값이 들어가지 않으면 예외가 발생한다.")
    void createLottoByNotRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호에 1부터 45의 값이 들어가지 않으면 예외가 발생한다.")
    void createBonusNumberByNotRange() {
        List<Integer> winningNumbers = Arrays.asList(10, 20, 30, 40, 45);
        int input = 50;
        assertDoesNotThrow(() -> {
            InputStream originalIn = System.in;
            try {
                byte[] inputBytes = { (byte) input };
                ByteArrayInputStream in = new ByteArrayInputStream(inputBytes);
                System.setIn(in);
                InputView.getBonusNumber(winningNumbers);
            } finally {
                System.setIn(originalIn);
            }
        });
    }

    @Test
    @DisplayName("보너스 넘버와 당첨 번호가 중복되면 예외가 발생한다.")
    void bonusNumberWinningNumbersSame() {
        List<Integer> winningNumbers = Arrays.asList(10, 20, 30, 40, 45);
        int bonusNumber = 30;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CustomizedException.bonusNumberWinningNumbersSame(winningNumbers, bonusNumber);
        });
        String expectedMessage = "당첨번호와 보너스 번호가 중복 되서는 안됩니다.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
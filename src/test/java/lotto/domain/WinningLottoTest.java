package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    @DisplayName("정상적인 당첨 번호 입력")
    void inputCorrectWinningLotto() {
        // Given
        String inputWinningLotto = "1,2,3,4,5,6";

        // When
        WinningLotto winningLotto = new WinningLotto(inputWinningLotto);
        Lotto lotto = winningLotto.getLotto();

        // Then
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("입력 값에 숫자 이외의 문자가 들어올 경우 예외가 발생한다.")
    void inputNotNumber() {
        // Given
        String inputWinningLotto = "1,2,3,a,4,5";

        // When & Then
        assertThatThrownBy(() -> new WinningLotto(inputWinningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값에 쉼표 구분자 이외의 문자가 들어올 경우 예외가 발생한다.")
    void inputNotComma() {
        // Given
        String inputWinningLotto = "1.2.3.4.5.6";

        // When & Then
        assertThatThrownBy(() -> new WinningLotto(inputWinningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

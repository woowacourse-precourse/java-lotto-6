package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("[Test - WinningLotto]")
public class WinningLottoTest {
    @Test
    @DisplayName("WinningLotto 생성 테스트 - 정상")
    void winningLottoTest() {
        // Given
        String userInputWinningLotto = "1,2,3,4,5,6";
        List<Integer> userInputWinningLottos = List.of(1,2,3,4,5,6);

        // When
        WinningLotto winningLotto = new WinningLotto(userInputWinningLotto);

        // Then
        assertThat(winningLotto.getWinningLottoNumbers()).isEqualTo(userInputWinningLottos);
    }

    @Test
    @DisplayName("WinningLotto 생성 테스트 - 6개의 숫자를 입력하지 않았을 경우")
    void winningLottoTest_validateAmountOfWinningLottoNumber() {
        // Given
        String userInputWinningLotto = "1,2,3,4,5,6,7";

        // When & Then
        assertThatThrownBy(() -> new WinningLotto(userInputWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("WinningLotto 생성 테스트 - 중복된 숫자를 입력했을 경우")
    void winningLottoTest_validateDuplicatedWinningLottoNumber() {
        // Given
        String userInputWinningLotto = "1,2,3,4,5,5";

        // When & Then
        assertThatThrownBy(() -> new WinningLotto(userInputWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}

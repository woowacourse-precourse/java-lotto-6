package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @ParameterizedTest
    @ValueSource(strings = {"1,2,삼,4,5,6", "!!!", "1,2,3, 4", "1,2,3, ,5,6", "1,2,3,4,5"})
    void 당첨_번호_입력_양식(String input) {
        assertThatCode(() -> Lotto.createWinningNumbers("1,2,3,4,5,6")).doesNotThrowAnyException();
        assertThatThrownBy(() -> Lotto.createWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    void 당첨_번호_범위(String input) {
        assertThatCode(() -> Lotto.createWinningNumbers("1,2,3,4,5,6")).doesNotThrowAnyException();
        assertThatThrownBy(() -> Lotto.createWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또는 1부터 45까지의 숫자만 사용됩니다.");
    }

    @Test
    void 당첨_번호_중복() {
        assertThatCode(() -> Lotto.createWinningNumbers("1,2,3,4,5,6")).doesNotThrowAnyException();
        assertThatThrownBy(() -> Lotto.createWinningNumbers("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 번호가 존재합니다. 다른 번호를 입력해주세요.");
    }
}
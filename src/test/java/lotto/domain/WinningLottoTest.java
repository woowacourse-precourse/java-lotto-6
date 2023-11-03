package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.utils.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 번호 로또 생성 성공")
    void createWinningLotto() {
        // given
        String s = "1,2,3,4,5,6";

        // when
        WinningLotto winningLotto = new WinningLotto(s);

        // then
        assertThat(winningLotto).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2.3.4.5.6", "1-2-3-4-5-6"})
    @DisplayName("당첨 번호를 쉼표(,)로 구분하지 않으면 에러가 발생한다.")
    void createWinningLottoByWrongDelimiter(String s) {
        assertThatThrownBy(() -> new WinningLotto(s))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_SPLIT_DELIMITER);
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createWinningLottoByOverSize() {
        // given
        String s = "1,2,3,4,5,6,7";

        // when // then
        assertThatThrownBy(() -> new WinningLotto(s))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBER_SIZE);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createWinningLottoByDuplicatedNumber() {
        // given
        String s = "1,2,3,4,5,5";

        // when // then
        assertThatThrownBy(() -> new WinningLotto(s))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.DUPLICATED_NUMBER);
    }

    @Test
    @DisplayName("당첨 번호가 1~45 사이의 숫자가 아니라면 예외가 발생한다.")
    void createWinningLottoByWrongRangeNumber() {
        // given
        String s = "0,46,3,4,5,6";

        // when // then
        assertThatThrownBy(() -> new WinningLotto(s))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBER_RANGE);
    }
}
package lotto.domain;

import static org.assertj.core.api.Assertions.*;

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
}
package lotto;

import Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoNotBetween1And45() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 46, 23, 31, 14, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 문자열 콤마를 기준으로 분리")
    @Test
    void splitLottoStringByComma() {
        String testLotto = "1,2,3,4,5,6";
        Lotto actualLotto = new Lotto(testLotto);
        Lotto expectedLotto = new Lotto(List.of(
                1, 2, 3, 4, 5, 6
        ));

        assertThat(actualLotto).isEqualTo(expectedLotto);
    }
}
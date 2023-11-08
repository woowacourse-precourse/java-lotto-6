package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.domain.Lotto;

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

    @Test
    @DisplayName("로또 번호에 0이 존재하면 예외가 발생한다.")
    void createLottoByZeroNumber() {
        // given
        var wrongList = List.of(7, 0, 2, 3, 15, 17);

        // then
        assertThatThrownBy(() -> new Lotto(wrongList))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 음수나 0이 존재하면 예외가 발생한다.")
    void createLottoByNegativeNumber() {
        // given
        var wrongList = List.of(-1, 7, 2, 3, 15, 17);

        // then
        assertThatThrownBy(() -> new Lotto(wrongList))
            .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}

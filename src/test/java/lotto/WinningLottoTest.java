package lotto;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


class WinningLottoTest {
    @DisplayName("정답 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7),8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정답 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5),7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 정답번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void createLottoWithSort() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6),6))
                .isInstanceOf(IllegalArgumentException.class);
    }




}
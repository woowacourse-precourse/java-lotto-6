package lotto.domain;

import lotto.domain.lottoDrawMachine.lottoDraw.LottoDraw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoDrawTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> LottoDraw.of(List.of(1, 2, 3, 4, 5, 6, 7),8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 보다 부족하면 예외가 발생한다.")
    @Test
    void createLottoByLessSize() {
        assertThatThrownBy(() -> LottoDraw.of(List.of(1, 2, 3, 4, 5),7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> LottoDraw.of(List.of(1, 2, 3, 4, 5, 5),6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중 1~45가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> LottoDraw.of(List.of(1, 2, 3, 4, 5, 6),47))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

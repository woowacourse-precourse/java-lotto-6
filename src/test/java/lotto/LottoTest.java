package lotto;

import lotto.LottoGameController.LottoGameController;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
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

    @DisplayName("로또 번호에 1~45 사이의 숫자가 들어가지 않으면 예외가 발생한다.")
    @Test
    void createLottoByOverRangeNumber() {

        assertThatThrownBy(()-> new Lotto(List.of(1,2,3,4,5,60)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 정답 번호 개수가 정확하지 않으면 예외가 발생한다.")
    @Test
    void validWinningNumberCount() {

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        HashSet<Integer> winningNumber = new HashSet<>();
        for (int i = 1; i < 7; i++) {
            winningNumber.add(i);
        }

        assertThat(lotto.countWinningNumber(winningNumber)).isEqualTo(6);
    }

}
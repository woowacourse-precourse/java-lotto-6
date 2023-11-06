package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("맞은 숫자의 개수에 따라 등수가 올바른가.")
    @Test
    void getWinningRank() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        int bonusNumber = 7;

        List<Integer> lotteryNumber = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lotteryNumber.add(i, i + 1);
        }

        //1등 확인
        Lotto lotto = new Lotto(lotteryNumber);
        assertThat(lotto.getWinningRank(winningNumbers, bonusNumber)).isEqualTo(1);

        //2등 확인
        lotteryNumber.set(0, 7);
        lotto = new Lotto(lotteryNumber);
        assertThat(lotto.getWinningRank(winningNumbers, bonusNumber)).isEqualTo(2);

        //3,4,5등 확인
        for (int i = 0; i < 3; i++) {
            lotteryNumber.set(i, i+10);
            lotto = new Lotto(lotteryNumber);
            assertThat(lotto.getWinningRank(winningNumbers, bonusNumber)).isEqualTo(3+i);
        }
    }

    // 아래에 추가 테스트 작성 가능
}
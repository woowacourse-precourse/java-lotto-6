package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @Test
    @DisplayName("일치하는 당첨 번호의 개수와 보너스 번호가 있는지 여부에 따라 당첨 결과가 나온다.")
    void checkReward() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;

        Lotto firstRewardLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondRewardLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdRewardLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto fourthRewardLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto fifthRewardLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto loseLotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));

        assertThat(firstRewardLotto.checkReward(winningNumber, bonus)).isEqualTo(Rewards.FIRST);
        assertThat(secondRewardLotto.checkReward(winningNumber, bonus)).isEqualTo(Rewards.SECOND);
        assertThat(thirdRewardLotto.checkReward(winningNumber, bonus)).isEqualTo(Rewards.THIRD);
        assertThat(fourthRewardLotto.checkReward(winningNumber, bonus)).isEqualTo(Rewards.FOURTH);
        assertThat(fifthRewardLotto.checkReward(winningNumber, bonus)).isEqualTo(Rewards.FIFTH);
        assertThat(loseLotto.checkReward(winningNumber, bonus)).isEqualTo(Rewards.LOSE);
    }
}
package lotto;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.Reward;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("당첨 번호가 모두 일치하는 경우 1등 이다.")
    @Test
    void matchAll(){
        assertMatch(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1, 2, 3, 4, 5, 6), 7, Reward.FIRST_REWARD);
    }
    @DisplayName("당첨 번호가 5개 일치하고 보너스 번호가 1개 일치하는 경우 2등 이다.")
    @Test
    void matchFour(){
        assertMatch(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1, 2, 3, 4, 5, 8), 6, Reward.SECOND_REWARD);
    }

    @DisplayName("당첨 번호가 5개 일치하는 경우 3등 이다.")
    @Test
    void matchFive(){
        assertMatch(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1, 2, 3, 4, 5, 8), 7, Reward.THIRD_REWARD);
    }
    @DisplayName("당첨 번호가 4개 일치하는 경우 4등 이다.")
    @Test
    void matchThree(){
        assertMatch(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1, 2, 3, 4, 10, 8), 7, Reward.FOURTH_REWARD);
    }
    @DisplayName("당첨 번호가 3개 일치하는 경우 5등 이다.")
    @Test
    void matchTwo(){
        assertMatch(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1, 2, 3, 14, 15, 8), 6, Reward.FIFTH_REWARD);
    }

    private static void assertMatch(List<Integer> lotto, List<Integer> luckyNumbers, int bonusNumber, Reward expectedReward) {
        Reward reward = new Lotto(lotto).match(luckyNumbers, bonusNumber);
        Assertions.assertThat(reward).isEqualTo(expectedReward);
    }
}
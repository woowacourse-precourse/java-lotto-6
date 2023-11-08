package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Lotto.randomLottery;
import static lotto.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    @DisplayName("숫자의 길이가 6자리가 맞고, 중복이 없을 경우")
    public void createLotto() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(nums);

        assertThat(lotto).isNotNull();
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("randomLottery 메서드 테스트 - 리스트의 숫자가 1과 45사이의 범위에 있는지")
    public void checkRandomLotteryInRange() {
        List<Integer> randomLottery = randomLottery();
        for (int number : randomLottery) {
            assertThat(number).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("randomLottery 메서드 테스트 - 리스트의 사이즈가 6개가 맞는지")
    public void checkRandomLotterySize() {
        List<Integer> randomLottery = randomLottery();
        assertThat(randomLottery.size()).isEqualTo(LOTTO_SIZE);
    }

    @Test
    @DisplayName("checkDuplicate 메서드 테스트 - 중복이 없을 때")
    public void checkDuplicate_WithoutDuplicates() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        Lotto.checkDuplicate(nums);
    }

    @Test
    @DisplayName("getLotto 메서드 테스트 - 원하는 개수만큼 Lotto객체 생성")
    public void getLotto() {
        int cnt = 8;
        List<Lotto> lotto = Lotto.getLotto(cnt);
        assertThat(lotto.size()).isEqualTo(cnt);
    }
}
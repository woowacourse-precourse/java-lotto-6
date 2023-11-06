package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("당첨 로또와 비교하여 당첨 결과를 생성할 수 있다.")
    @Test
    void getCompareResult() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = WinningLotto.createFrom(numbers, bonusNumber);
        Lotto lotto = Lotto.createFrom(numbers);

        // when
        LottoRewardCondition result = winningLotto.findCompareResult(lotto);

        // then
        assertThat(result).isEqualTo(LottoRewardCondition.FIRST_WINNER);
    }
}
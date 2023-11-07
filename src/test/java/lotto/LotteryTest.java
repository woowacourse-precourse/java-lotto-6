package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryTest {

    @DisplayName("보너스 번호가 로또 번호 중 하나라면 예외가 발생한다.")
    @Test
    void givenValidLotto_whenCreateLotteryWithDuplicatedBonusNumber_thenThrowException() {
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new Lottery(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }


}

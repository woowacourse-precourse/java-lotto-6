package lotto.model.winninglotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HitCounterTest {

    @Test
    @DisplayName("HitCounter를 생성할 수 있다.")
    void createHitCounterTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(new HitCounter(winningNumbers, 7))
            .isInstanceOf(HitCounter.class);
    }

    @Test
    @DisplayName("HitCounter를 통해 숫자 일치 갯수를 셀 수 있다.")
    void hitCountTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        HitCounter hitCounter = new HitCounter(winningNumbers, 7);
        HitResult hitResult = hitCounter.countHit(winningNumbers);

        assertThat(hitResult.hitCount()).isEqualTo(winningNumbers.size());
    }

    @Test
    @DisplayName("HitCounter를 통해 보너스 숫자 일치 여부를 확인할 수 있다.")
    void hitBonusBallTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        HitCounter hitCounter = new HitCounter(winningNumbers, 7);

        List<Integer> bonusBallHitNumbers = List.of(2, 3, 4, 5, 6, 7);
        List<Integer> bonusBallNotHitNumbers = List.of(1, 2, 3, 4, 5, 6);

        HitResult bonusBallHitResult = hitCounter.countHit(bonusBallHitNumbers);
        HitResult bonusBallNotHitResult = hitCounter.countHit(bonusBallNotHitNumbers);

        assertAll(
            () -> assertThat(bonusBallHitResult.isBonusBallHit()).isTrue(),
            () -> assertThat(bonusBallNotHitResult.isBonusBallHit()).isFalse()
        );
    }
}

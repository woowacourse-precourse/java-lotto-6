package lotto.domain.player;

import lotto.domain.common.Money;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Player player = Player.from(Money.from(8000), LottoMachine.from(simpleFactory()));
    }

    @DisplayName("알 수 없는 로또 기계로 플레이어를 생성할 수 없다.")
    @Test
    void checkLottoMachineNonNull() {
        assertThatThrownBy(() -> Player.from(Money.from(8000), null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 로또 기계로 플레이어를 생성할 수 없습니다.");
    }


    private LottoFactory simpleFactory() {
        Queue<List<Integer>> queue = new LinkedList<>(
                List.of(List.of(8, 21, 23, 41, 42, 43),
                        List.of(3, 5, 11, 16, 32, 38),
                        List.of(7, 11, 16, 35, 36, 44),
                        List.of(1, 8, 11, 31, 41, 42),
                        List.of(13, 14, 16, 38, 42, 45),
                        List.of(7, 11, 30, 40, 42, 43),
                        List.of(2, 13, 22, 32, 38, 45),
                        List.of(1, 3, 5, 14, 22, 45)));

        return () -> Lotto.from(queue.poll());
    }
}

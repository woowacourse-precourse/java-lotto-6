package lotto.model;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningTest {
    @Test
    void 당첨번호_6개_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6,7));

        Assertions.assertThatThrownBy(() -> new Winning(winningNumbers, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 6개여야 합니다.");
    }

    @Test
    void 당첨번호_범위_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,53,300,4,5,6));

        Assertions.assertThatThrownBy(() -> new Winning(winningNumbers, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 당첨번호_중복_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,5));

        Assertions.assertThatThrownBy(() -> new Winning(winningNumbers, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("모든 숫자는 중복되지 않아야 합니다.");
    }
}

package lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import lotto.enums.Prize;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    private static final Map<Prize, Integer> prizes = Map.of(Prize.FIRST, 1, Prize.SECOND, 2, Prize.THIRD, 3);

    @Test
    void Prize를_키로_값을_가져온다() {
        // given
        WinningResult winningResult = new WinningResult(prizes);

        // when
        int first = winningResult.countOf(Prize.FIRST);
        int second = winningResult.countOf(Prize.SECOND);
        int third = winningResult.countOf(Prize.THIRD);

        // then
        assertAll(
                () -> assertEquals(1, first),
                () -> assertEquals(2, second),
                () -> assertEquals(3, third)
        );
    }

    @Test
    void Prize_키가_없을_때_기본값을_반환한다() {
        // given
        WinningResult winningResult = new WinningResult(prizes);

        // when
        int fourth = winningResult.countOf(Prize.FOURTH);

        // then
        assertThat(fourth).isZero();
    }
}
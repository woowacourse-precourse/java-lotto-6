package test;

import lotto.config.LottoPrize;
import lotto.model.LottoDraw;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoDrawTest {
    @Test
    void 당첨번호0개() {
        assertThat(new LottoDraw(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(7, 8, 9, 10, 11, 12, 13),
                        5
                ).getPrize()
        ).isEqualTo(LottoPrize.MATCH_0);
    }

    @Test
    void 당첨번호1개() {
        assertThat(new LottoDraw(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(2, 7, 8, 9, 10, 11, 12),
                        5
                ).getPrize()
        ).isEqualTo(LottoPrize.MATCH_1);
    }

    @Test
    void 당첨번호2개() {
        assertThat(new LottoDraw(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 7, 8, 9, 10, 11),
                        45
                ).getPrize()
        ).isEqualTo(LottoPrize.MATCH_2);
    }

    @Test
    void 당첨번호3개() {
        assertThat(new LottoDraw(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 8, 9, 10),
                        45
                ).getPrize()
        ).isEqualTo(LottoPrize.MATCH_3);
    }

    @Test
    void 당첨번호4개() {
        assertThat(new LottoDraw(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 8, 9),
                        45
                ).getPrize()
        ).isEqualTo(LottoPrize.MATCH_4);
    }

    @Test
    void 당첨번호5개() {
        assertThat(new LottoDraw(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 8),
                        9
                ).getPrize()
        ).isEqualTo(LottoPrize.MATCH_5);
    }

    @Test
    void 당첨번호5개_보너스o() {
        assertThat(new LottoDraw(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 6, 7),
                        5
                ).getPrize()
        ).isEqualTo(LottoPrize.MATCH_5BONUS);
    }

    @Test
    void 당첨번호6개() {
        assertThat(new LottoDraw(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        7
                ).getPrize()
        ).isEqualTo(LottoPrize.MATCH_6);
    }
}

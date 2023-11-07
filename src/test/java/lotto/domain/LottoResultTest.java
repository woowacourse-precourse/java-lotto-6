package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 결과에 대한 테스트")
class LottoResultTest {
    static final WinningLotto WINNING_LOTTO = new WinningLotto(new Lotto(List.of(8, 2, 3, 4, 6, 5)), 7);
    @Test
    void 당첨_결과_초기상태() {
        LottoResult lottoResult = new LottoResult(1000);
        for (LottoPrize prize : LottoPrize.values()) {
            assertEquals(0, lottoResult.prizeResult.get(prize));
        }
    }

    @Test
    void 당첨_결과_1등_2등_3등() {
        LottoResult lottoResult = new LottoResult(1000);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(6, 2, 8, 3, 4, 5)),
                new Lotto(List.of(7, 2, 3, 4, 5, 6)),
                new Lotto(List.of(9, 2, 3, 4, 5, 6))
        );

        lottoResult.calculateWinningResult(WINNING_LOTTO, lottos);
        assertEqualsResult(lottoResult, 1, 1, 1, 0, 0, 0);
    }

    @Test
    void 당첨_결과_4등_5등_꽝_보너스번호_포함() {
        LottoResult lottoResult = new LottoResult(1000);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(7, 2, 3, 4, 6, 45)),
                new Lotto(List.of(11, 2, 10, 3, 4, 12)),
                new Lotto(List.of(7, 9, 11, 13, 15, 17))
        );

        lottoResult.calculateWinningResult(WINNING_LOTTO, lottos);
        assertEqualsResult(lottoResult, 0, 0, 0, 1, 1, 1);
    }

    @Test
    void 당첨_결과_같은등수_여러장() {
        LottoResult lottoResult = new LottoResult(1000);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(9, 2, 3, 4, 5, 6)),
                new Lotto(List.of(9, 2, 3, 4, 5, 6))
        );

        lottoResult.calculateWinningResult(WINNING_LOTTO, lottos);
        assertEqualsResult(lottoResult, 0, 0, 2, 0, 0, 0);
    }

    void assertEqualsResult(
            LottoResult lottoResult, int first, int second, int third, int fourth, int fifth, int etc
    ) {
        assertEquals(first, lottoResult.getPrizeResult().get(LottoPrize.FIRST));
        assertEquals(second, lottoResult.getPrizeResult().get(LottoPrize.SECOND));
        assertEquals(third, lottoResult.getPrizeResult().get(LottoPrize.THIRD));
        assertEquals(fourth, lottoResult.getPrizeResult().get(LottoPrize.FOURTH));
        assertEquals(fifth, lottoResult.getPrizeResult().get(LottoPrize.FIFTH));
        assertEquals(etc, lottoResult.getPrizeResult().get(LottoPrize.ETC));
    }

    @Test
    @Disabled("LottoResult 클래스의 메서드의 접근제어를 private으로 변경")
    void 등수_계산과_수익률_계산() {
        LottoResult lottoResult = new LottoResult(3000);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(8, 3, 5, 14, 22, 45))
        );
        lottoResult.calculateWinningResult(WINNING_LOTTO, lottos);
        assertEqualsResult(lottoResult, 0, 0, 0, 0, 1, 2);
        // lottoResult.calculateTotalPrizeMoney();
        // assertEquals(166.7, lottoResult.getYieldRate());
    }

    @Test
    @Disabled("LottoResult 클래스의 메서드의 접근제어를 private으로 변경")
    void 정수형을_초과한_수익에_대한_수익률_계산() {
        LottoResult lottoResult = new LottoResult(2000);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(8, 2, 3, 4, 6, 5)),
                new Lotto(List.of(8, 2, 3, 4, 6, 5)),
                new Lotto(List.of(8, 2, 3, 4, 6, 5))
        );
        lottoResult.calculateWinningResult(WINNING_LOTTO, lottos);
        assertEqualsResult(lottoResult, 3, 0, 0, 0, 0, 0);
        // lottoResult.calculateTotalPrizeMoney();
        // assertEquals(3e8, lottoResult.getYieldRate());
    }
}
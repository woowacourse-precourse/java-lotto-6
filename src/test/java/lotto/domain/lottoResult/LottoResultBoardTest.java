package lotto.domain.lottoResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.PurchaseAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultBoardTest {

    private Map<LottoRank, Long> totalLottoResult;

    @BeforeEach
    void setUp() {
        totalLottoResult = Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(key -> key, key -> 0L));
        updateLottoMatchCount(LottoRank.FIRST);
        updateLottoMatchCount(LottoRank.FIFTH);
    }


    @DisplayName("객체 생성을 확인한다")
    @Test
    void generateLottoResultBoard() {
        // given
        LottoResultBoard lottoResultBoard = LottoResultBoard.of(totalLottoResult);

        // when
        // then
        Assertions.assertThat(lottoResultBoard).isNotNull();
    }

    @DisplayName("LottoRank 순위로 matchCount 를 알 수 있다.")
    @Test
    void findMatchCountByLottoRank() {
        // given
        LottoResultBoard lottoResultBoard = LottoResultBoard.of(totalLottoResult);

        // when
        long firstMatchCount = lottoResultBoard.findMatchCount(LottoRank.FIRST);
        long secondMatchCount = lottoResultBoard.findMatchCount(LottoRank.SECOND);
        long thirdMatchCount = lottoResultBoard.findMatchCount(LottoRank.THIRD);
        long fourthMatchCount = lottoResultBoard.findMatchCount(LottoRank.FOURTH);
        long fifthMatchCount = lottoResultBoard.findMatchCount(LottoRank.FIFTH);

        // then
        assertEquals(1, firstMatchCount);
        assertEquals(0, secondMatchCount);
        assertEquals(0, thirdMatchCount);
        assertEquals(0, fourthMatchCount);
        assertEquals(1, fifthMatchCount);
    }

    @DisplayName("로또 당첨 총 수익금을 계산한다.")
    @Test
    void calculateWinningAmountSum() {
        // given
        LottoResultBoard lottoResultBoard = LottoResultBoard.of(totalLottoResult);

        // when
        long winningAmountSum = lottoResultBoard.calculateWinningAmountSum();

        // then
        assertEquals(2_000_005_000, winningAmountSum);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfitabilityPercent() {
        // given
        LottoResultBoard lottoResultBoard = LottoResultBoard.of(totalLottoResult);

        // when
        double profitabilityPercent = lottoResultBoard.calculateProfitabilityPercent(PurchaseAmount.from(10000));

        // then
        assertEquals(2.000005E7, profitabilityPercent);
    }

    private void updateLottoMatchCount(LottoRank lottoRank) {
        long currentLottoRankCount = totalLottoResult.get(lottoRank);
        totalLottoResult.put(lottoRank, currentLottoRankCount + 1);
    }
}
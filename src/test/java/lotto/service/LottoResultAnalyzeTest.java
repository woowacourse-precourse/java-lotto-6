package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultAnalyzeTest {

    private LottoResultAnalyze lottoResultAnalyze;

    @BeforeEach
    void setUp() {
        lottoResultAnalyze = new LottoResultAnalyze();
    }

    @DisplayName("로또 결과 분석 테스트")
    @Test
    public void analyzeLottoResults() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        List<Lotto> lottoTicket = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등 (6개 일치)
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등 (5개 일치, 보너스 볼 일치)
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등 (5개 일치)
                new Lotto(List.of(1, 2, 3, 4, 9, 10)), // 4등 (4개 일치)
                new Lotto(List.of(1, 2, 3, 11, 12, 13)), // 5등 (3개 일치)
                new Lotto(List.of(14, 15, 16, 17, 18, 19)) // 꽝
        );

        Map<String, Integer> result = lottoResultAnalyze.calculateResult(lottoTicket, winningNumbers, bonusNumber);

        assertEquals(1, result.get(LottoRank.FIRST_PLACE.getRank()));
        assertEquals(1, result.get(LottoRank.SECOND_PLACE.getRank()));
        assertEquals(1, result.get(LottoRank.THIRD_PLACE.getRank()));
        assertEquals(1, result.get(LottoRank.FOURTH_PLACE.getRank()));
        assertEquals(1, result.get(LottoRank.FIFTH_PLACE.getRank()));
    }
}
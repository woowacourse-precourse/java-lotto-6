package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    @Test
    @DisplayName("총 수익금 반환 테스트")
    void getTotalReward() {
        //총 31,505,000원이 당첨 되게끔 lotto 생성
        List<Lotto> lottoLists = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등 (30,000,000원)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)), // 3등 (1,500,000원)
                new Lotto(Arrays.asList(1, 2, 3, 41, 42, 43)), // 5등 (5,000원)
                new Lotto(Arrays.asList(9, 10, 11, 12, 13, 14)) // 낙첨 (0원)
        );

        List<Integer> winningNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;

        LottoResult lottoResult = new LottoResult(lottoLists, winningNum, bonusNum);

        int totalReward = lottoResult.getTotalReward();

        assertEquals(31505000, totalReward);
    }

    @Test
    @DisplayName("로또 결과 몇 장씩 있는 지 반환하는 테스트")
    void getLottoResult() {
        //1등 1장, 2등 1장, 3등 2장, 4등 0장, 5등 1장, 낙첨 1장이 되게끔 lotto 생성
        List<Lotto> lottoLists = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)), // 3등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 20)), // 3등
                new Lotto(Arrays.asList(1, 2, 3, 41, 42, 43)), // 5등
                new Lotto(Arrays.asList(9, 10, 11, 12, 13, 14)) // 낙첨
        );

        List<Integer> winningNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;

        LottoResult lottoResult = new LottoResult(lottoLists, winningNum, bonusNum);

        Map<Prize, Integer> result = lottoResult.getLottoResult();

        assertEquals(1, result.get(Prize.FIRST_GRADE));
        assertEquals(1, result.get(Prize.SECOND_GRADE));
        assertEquals(2, result.get(Prize.THIRD_GRADE));
        assertEquals(0, result.get(Prize.FOURTH_GRADE));
        assertEquals(1, result.get(Prize.FIFTH_GRADE));
        assertEquals(1, result.get(Prize.FAIL));
    }
}

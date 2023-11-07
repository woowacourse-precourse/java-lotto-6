package lotto.domain;

import lotto.global.constant.LottoRankAndPrize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankAndPrizeTest {

    @Test
    public void testDetermineRankByLottoMatched() {
        // 테스트할 입력값 설정
        int lottoMatched = 6; // 예시로 6개의 숫자 일치
        boolean bonusMatched = true; // 예시로 보너스 번호도 일치

        // determineRankByLottoMatched 함수를 호출하여 로또 순위를 확인
        LottoRankAndPrize result = LottoRankAndPrize.determineRankByLottoMatched(lottoMatched, bonusMatched);

        // 예상되는 결과는 SECOND_RANK (2등)입니다.
        assertEquals(LottoRankAndPrize.SECOND_RANK, result);
    }

    @Test
    public void testDetermineRankByLottoMatchedNoRank() {
        // 테스트할 입력값 설정
        int lottoMatched = 2; // 예시로 2개의 숫자 일치
        boolean bonusMatched = false; // 예시로 보너스 번호 일치하지 않음

        // determineRankByLottoMatched 함수를 호출하여 로또 순위를 확인
        LottoRankAndPrize result = LottoRankAndPrize.determineRankByLottoMatched(lottoMatched, bonusMatched);

        // 예상되는 결과는 NO_RANK (꽝)입니다.
        assertEquals(LottoRankAndPrize.NO_RANK, result);
    }
}

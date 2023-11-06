package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class WinningResultTest {

    @Test
    @DisplayName("로또 순위 판별 뒤, map의 값을 검증한다.")
    void addRanking_checkMapKey1() {
        /**
         * given : MATCH_FOUR가 주어진다.
         * when : addRanking()을 호출한다.
         * then : MATCH_FOUR가 2번 추가되었음으로, map의 value는 2다.
         */
        LottoRanking ranking1 = LottoRanking.MATCH_FOUR;
        LottoRanking ranking2 = LottoRanking.MATCH_FOUR;

        WinningResult winningResult = new WinningResult();
        winningResult.addRanking(ranking1);
        winningResult.addRanking(ranking2);

        Assertions.assertThat(winningResult.getWinningResult().get(ranking1)).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨 결과가 Map에 저장되는지 확인한다.")
    void addRanking_checkMapValue2() {
        /**
         * given : MATCH_FOUR가 주어진다.
         * when : addRanking()을 호출한다.
         * then : MATCH_FOUR가 1번 추가되었음으로, map의 value는 1다.
         */
        LottoRanking ranking = LottoRanking.MATCH_FOUR;

        WinningResult winningResult = new WinningResult();
        winningResult.addRanking(ranking);

        Assertions.assertThat(winningResult.getWinningResult().get(ranking)).isEqualTo(1);
    }
}
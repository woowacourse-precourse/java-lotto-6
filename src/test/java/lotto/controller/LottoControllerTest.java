package lotto.controller;

import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoControllerTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호의 중복을 검증한다.")
    void validateDuplicatedNumber_throwException() {
        /**
         * given : 당첨 번호와 보너스 번호가 주어진다.
         * when : 당첨 번호와 보너스 번호의 중복을 검증한다.
         * then : IllegalArgumentException 예외가 발생한다.
         */
        List<Integer> winningNums = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 6;

        assertThatThrownBy(() -> validateDuplicatedNumber(winningNums, bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void validateDuplicatedNumber(List<Integer> winningNums, int bonusNum) {
        if (winningNums.contains(bonusNum)) {
            throw new IllegalArgumentException();
        }
    }

    @Test
    @DisplayName("로또 일치 여부를 계산하는 메서드를 통합 테스트한다. ")
    void calculateWinningResult_integration() {
        /**
         * given : 당첨, 보너스 번호와 로또 3개가 담긴 티켓이 주어진다.
         * when : 결과를 계산한다.(calculate)
         * then : 예상한 map과 같은 map이 반환된다.
         */

        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(10, 11, 12, 13, 14, 15));
        List<Lotto> tickets = List.of(lotto1, lotto2, lotto3);

        WinningResult result = calulcate(tickets, winningNumber, bonusNumber);

        Map<LottoRanking, Integer> expectedMap = Map.of(
                LottoRanking.MATCH_SIX, 1,
                LottoRanking.MATCH_FIVE_BONUS, 1,
                LottoRanking.NONE_MATCH, 1
        );
        assertThat(result.getWinningResult()).isEqualTo(expectedMap);
    }

    private WinningResult calulcate(List<Lotto> tickets, WinningNumber winningNumber, BonusNumber bonusNumber) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : tickets) {
            int matchCount = lotto.getMatchCount(winningNumber);
            boolean hasBonus = lotto.hasBonus(bonusNumber);
            LottoRanking ranking = LottoRanking.determineRanking(matchCount, hasBonus);
            winningResult.addRanking(ranking);
        }
        return winningResult;
    }
}
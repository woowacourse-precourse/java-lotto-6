package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class utilTest {

    private CompareLotto compareLotto = new CompareLotto();

    @Test
    @DisplayName("총 수익률 변환 테스트")
    void CalculateRate() {
        double totalRate = CalculateRate.getTotalRate(8000, 5000);
        assertThat(totalRate).isEqualTo(62.5);
    }

    @Test
    @DisplayName("로또와 당첨 번호 비교 후 같은 숫자가 몇 개인 지 반환하는 함수 테스트")
    void compareCount() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNum = List.of(1, 10, 20, 30, 40, 6);
        assertThat(compareLotto.getCompareCount(lotto, winningNum)).isEqualTo(2);
    }

    @Test
    @DisplayName("로또와 보너스 숫자 같을 시 true 를 반환하는 함수 테스트")
    void compareBonusNum() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 3;
        assertThat(compareLotto.getMatchBonus(lotto, bonusNum)).isEqualTo(true);
    }

    @Test
    @DisplayName("구매 금액을 로또 티켓으로 변환하는 함수 테스트")
    void getLottoTickets() {
        assertThat(GenerateTicket.getLottoTickets(5000)).isEqualTo(5);
    }

}

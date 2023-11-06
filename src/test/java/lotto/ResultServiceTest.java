package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultServiceTest {

    @DisplayName("로또 수량을 제대로 계산하는 지 테스트한다.")
    @Test
    void calculateNumberOfLottoTicketsTest() {
        // given
        int purchaseAmount = 9000;

        // when & then
        assertThat(ResultService.calculateNumberOfLottoTickets(purchaseAmount))
                .isEqualTo(9);
    }

    @DisplayName("입력된 로또 수량만큼 로또를 발행하는 지 테스트한다.")
    @Test
    void getResultsOfLottoIssuanceTest() {
        // given
        int purchaseNumber = 9;

        // when & then
        assertThat(ResultService.getResultsOfLottoIssuance(purchaseNumber).size())
                .isEqualTo(9);
    }

    @DisplayName("발행된 로또 숫자를 오름차순으로 정렬하는 지 테스트한다.")
    @Test
    void printSortResultTest() {
        // given
        Lotto lotto = new Lotto(List.of(15, 8, 6, 7, 3, 9));
        List<Integer> sortedLotto = new ArrayList<>(List.of(3, 6, 7, 8, 9, 15));

        // when & then
        assertThat(lotto.sortNumbers(lotto)).isEqualTo(sortedLotto);
    }


}
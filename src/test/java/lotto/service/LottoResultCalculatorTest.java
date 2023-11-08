package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCalculatorTest {

    /**
     * lottoResult는 6개의 정수값을 가진다. 각각의 값은 앞에서 부터 꽝, 1등, 2등, 3등, 4등, 5등이 당첨된 수를 나타낸다.
     */

    private final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    private final int bonusNumber = 7;
    private final LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumbers, bonusNumber);

    @DisplayName("로또 번호가 당첨 번호와 2개 이하 일치하면 꽝이다.")
    @Test
    void LottoResultCalculator_No_Winning() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(List.of(1, 2, 7, 8, 9, 10)));

        List<Integer> lottoResult = lottoResultCalculator.getLottoResult(lottoTickets);
        assertThat(lottoResult).isEqualTo(List.of(1, 0, 0, 0, 0, 0));
    }

    @DisplayName("로또 번호가 당첨 번호와 모두 일치하면 1등이 당첨된다.")
    @Test
    void LottoResultCalculator_All_Match() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> lottoResult = lottoResultCalculator.getLottoResult(lottoTickets);
        assertThat(lottoResult).isEqualTo(List.of(0, 1, 0, 0, 0, 0));
    }

    @DisplayName("로또 번호가 당첨 번호와 5개 일치하고 보너스 번호가 있으면 2등이 당첨된다.")
    @Test
    void LottoResultCalculator_Match_Five_Has_Bonus() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        List<Integer> lottoResult = lottoResultCalculator.getLottoResult(lottoTickets);
        assertThat(lottoResult).isEqualTo(List.of(0, 0, 1, 0, 0, 0));
    }

    @DisplayName("로또 번호가 당첨 번호와 5개 일치하고 보너스 번호가 없으면 3등이 당첨된다.")
    @Test
    void LottoResultCalculator_Match_Five_No_Bonus() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        List<Integer> lottoResult = lottoResultCalculator.getLottoResult(lottoTickets);
        assertThat(lottoResult).isEqualTo(List.of(0, 0, 0, 1, 0, 0));
    }

    @DisplayName("로또 번호가 당첨 번호와 4개 일치하면 4등이 당첨된다.")
    @Test
    void LottoResultCalculator_Match_Four() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));

        List<Integer> lottoResult = lottoResultCalculator.getLottoResult(lottoTickets);
        assertThat(lottoResult).isEqualTo(List.of(0, 0, 0, 0, 1, 0));
    }

    @DisplayName("로또 번호가 당첨 번호와 3개 일치하면 5등이 당첨된다.")
    @Test
    void LottoResultCalculator_Match_Three() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));

        List<Integer> lottoResult = lottoResultCalculator.getLottoResult(lottoTickets);
        assertThat(lottoResult).isEqualTo(List.of(0, 0, 0, 0, 0, 1));
    }

    @DisplayName("꽝 부터 1등까지 모두 당첨될 수도 있다.")
    @Test
    void LottoResultCalculator() {
        List<List<Integer>> numbers = List.of(
            List.of(1, 2, 7, 8, 9, 10), List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7),
            List.of(1, 2, 3, 4, 5, 8), List.of(1, 2, 3, 4, 7, 8), List.of(1, 2, 3, 7, 8, 9)
        );
        List<Lotto> lottoTickets = new ArrayList<>();
        for (List<Integer> number : numbers) {
            lottoTickets.add(new Lotto(number));
        }

        List<Integer> lottoResult = lottoResultCalculator.getLottoResult(lottoTickets);
        assertThat(lottoResult).isEqualTo(List.of(1, 1, 1, 1, 1, 1));
    }

}
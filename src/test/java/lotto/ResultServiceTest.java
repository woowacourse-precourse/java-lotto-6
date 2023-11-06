package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
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
    void sortNumbersTest() {
        // given
        Lotto lotto = new Lotto(List.of(15, 8, 6, 7, 3, 9));
        List<Integer> sortedLotto = new ArrayList<>(List.of(3, 6, 7, 8, 9, 15));

        // when & then
        assertThat(lotto.sortNumbers(lotto)).isEqualTo(sortedLotto);
    }

    @DisplayName("숫자가 5개 일치하고 보너스가 일치하는 경우 저장이 잘 되는지 테스트한다.")
    @Test
    void saveWinningResultTest_Bonus() {
        // given
        int bonusNumber = 2;
        Lotto lotto = new Lotto(List.of(15, 8, 6, 7, 3, 9));
        Lotto resultOfLottoIssuance = new Lotto(List.of(15, 8, 6, 7, 3, 2));
        HashMap<Integer, Integer> winningResults = new HashMap<>();
        ResultService.makeInitialSettings(winningResults);

        // when
        ResultService.saveWinningResult(lotto, bonusNumber, resultOfLottoIssuance, winningResults);

        // when
        assertThat(winningResults.get(ResultService.FIVE_AND_BONUS_CASE_NUMBER)).isEqualTo(1);
        assertThat(winningResults.get(ResultService.THREE_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.FOUR_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.FIVE_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.SIX_CASE_NUMBER)).isEqualTo(0);
    }

    @DisplayName("숫자가 3개 일치하는 경우 저장이 잘 되는지 테스트한다.")
    @Test
    void saveWinningResultTest_THREE() {
        // given
        int bonusNumber = 2;
        Lotto lotto = new Lotto(List.of(15, 8, 6, 7, 3, 9));
        Lotto resultOfLottoIssuance = new Lotto(List.of(15, 8, 6, 12, 13, 22));
        HashMap<Integer, Integer> winningResults = new HashMap<>();
        ResultService.makeInitialSettings(winningResults);

        // when
        ResultService.saveWinningResult(lotto, bonusNumber, resultOfLottoIssuance, winningResults);

        // then
        assertThat(winningResults.get(ResultService.FIVE_AND_BONUS_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.THREE_CASE_NUMBER)).isEqualTo(1);
        assertThat(winningResults.get(ResultService.FOUR_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.FIVE_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.SIX_CASE_NUMBER)).isEqualTo(0);
    }

    @DisplayName("숫자가 4개 일치하는 경우 저장이 잘 되는지 테스트한다.")
    @Test
    void saveWinningResultTest_FOUR() {
        // given
        int bonusNumber = 2;
        Lotto lotto = new Lotto(List.of(15, 8, 6, 7, 3, 9));
        Lotto resultOfLottoIssuance = new Lotto(List.of(15, 8, 6, 7, 13, 22));
        HashMap<Integer, Integer> winningResults = new HashMap<>();
        ResultService.makeInitialSettings(winningResults);

        // when
        ResultService.saveWinningResult(lotto, bonusNumber, resultOfLottoIssuance, winningResults);

        // then
        assertThat(winningResults.get(ResultService.FIVE_AND_BONUS_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.THREE_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.FOUR_CASE_NUMBER)).isEqualTo(1);
        assertThat(winningResults.get(ResultService.FIVE_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.SIX_CASE_NUMBER)).isEqualTo(0);
    }

    @DisplayName("숫자가 5개 일치하는 경우 저장이 잘 되는지 테스트한다.")
    @Test
    void saveWinningResultTest_FIVE() {
        // given
        int bonusNumber = 2;
        Lotto lotto = new Lotto(List.of(15, 8, 6, 7, 3, 9));
        Lotto resultOfLottoIssuance = new Lotto(List.of(15, 8, 6, 7, 3, 22));
        HashMap<Integer, Integer> winningResults = new HashMap<>();
        ResultService.makeInitialSettings(winningResults);

        // when
        ResultService.saveWinningResult(lotto, bonusNumber, resultOfLottoIssuance, winningResults);

        // then
        assertThat(winningResults.get(ResultService.FIVE_AND_BONUS_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.THREE_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.FOUR_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.FIVE_CASE_NUMBER)).isEqualTo(1);
        assertThat(winningResults.get(ResultService.SIX_CASE_NUMBER)).isEqualTo(0);
    }

    @DisplayName("숫자가 6개 일치하는 경우 저장이 잘 되는지 테스트한다.")
    @Test
    void saveWinningResultTest_SIX() {
        // given
        int bonusNumber = 2;
        Lotto lotto = new Lotto(List.of(15, 8, 6, 7, 3, 9));
        Lotto resultOfLottoIssuance = new Lotto(List.of(15, 8, 6, 7, 3, 9));
        HashMap<Integer, Integer> winningResults = new HashMap<>();
        ResultService.makeInitialSettings(winningResults);

        // when
        ResultService.saveWinningResult(lotto, bonusNumber, resultOfLottoIssuance, winningResults);

        // then
        assertThat(winningResults.get(ResultService.FIVE_AND_BONUS_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.THREE_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.FOUR_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.FIVE_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.SIX_CASE_NUMBER)).isEqualTo(1);
    }

    @DisplayName("구매한 로또 2개의 일치 여부 저장이 잘 되는지 테스트한다.")
    @Test
    void saveWinningResultsTest() {
        // given
        int bonusNumber = 2;
        Lotto lotto = new Lotto(List.of(15, 8, 6, 7, 3, 9));
        Lotto resultOfLottoIssuance1 = new Lotto(List.of(15, 8, 6, 7, 3, 9));
        Lotto resultOfLottoIssuance2 = new Lotto(List.of(15, 8, 6, 7, 3, 1));
        HashMap<Integer, Integer> winningResults = new HashMap<>();
        List<Lotto> resultsOfLottoIssuance = new ArrayList<>();
        resultsOfLottoIssuance.add(resultOfLottoIssuance1);
        resultsOfLottoIssuance.add(resultOfLottoIssuance2);

        // when
        winningResults = ResultService.saveWinningResults(resultsOfLottoIssuance, lotto, bonusNumber);

        // then
        assertThat(winningResults.get(ResultService.FIVE_AND_BONUS_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.THREE_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.FOUR_CASE_NUMBER)).isEqualTo(0);
        assertThat(winningResults.get(ResultService.FIVE_CASE_NUMBER)).isEqualTo(1);
        assertThat(winningResults.get(ResultService.SIX_CASE_NUMBER)).isEqualTo(1);
    }

}
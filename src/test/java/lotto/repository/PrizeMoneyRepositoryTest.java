package lotto.repository;

import lotto.domain.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeMoneyRepositoryTest {

    @ParameterizedTest
    @CsvSource(value = {"FIRST, 2000000000", "SECOND, 30000000", "THIRD, 1500000", "FOURTH, 50000", "FIFTH, 5000"})
    @DisplayName("당첨 순위별 상금이 얼마인지 알 수 있다.")
    void findByLottoRanking(LottoRanking ranking, int expected) {
        PrizeMoneyRepository prizeMoneyRepository = new PrizeMoneyRepository();

        int actual = prizeMoneyRepository.findByLottoRanking(ranking);

        assertThat(actual).isEqualTo(expected);
    }
}
package lotto.repository.rank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoNumbersPerRankTest {

    @DisplayName("등수를 입력하면 몇개의 로또가 있는지 알려줍니다.")
    @ParameterizedTest
    @CsvSource(value = {"5,3","4,0","3,3","2,1","2,1"})
    void plusLottoNumbers(int rank , int number) {
        LottoNumbersPerRank.create();
        // when
        int[] ranks = {5,5,5,3,3,3,1,1,2};
        for (int num : ranks) {
            LottoNumbersPerRank.plus(num);
        }
        // then
        assertThat(LottoNumbersPerRank.getNumberBy(rank)).isEqualTo(number);
    }
}
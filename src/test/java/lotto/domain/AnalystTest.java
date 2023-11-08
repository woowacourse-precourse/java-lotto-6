package lotto.domain;

import static lotto.domain.LottoRank.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AnalystTest {
    Analyst analyst;

    @BeforeEach
    void setUp() {
        this.analyst = new Analyst(3);
    }

    @DisplayName("숫자별 등수를 찾아 기록하는 기능")
    @ParameterizedTest
    @CsvSource({"6,false"})
    void addLottoResult_TEST(String winner, String bonus) {
        int winningNum = Integer.parseInt(winner);
        boolean containBonusNum = Boolean.parseBoolean(bonus);
        analyst.addLottoResult(winningNum, containBonusNum);
        assertThat(RANK1.getCount()).isEqualTo(1);
    }

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @CsvSource(value = {"6,false"})
    void revenueLotto_TEST() {

    };
}
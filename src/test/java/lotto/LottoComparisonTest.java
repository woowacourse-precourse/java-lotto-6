package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoComparisonTest {
    private LottoComparison lottoComparison;

    @BeforeEach
    void setUP() {
        lottoComparison = new LottoComparison(3, true);
    }

    @DisplayName("주어진 객체의 중복번호 숫자에 해당하는 값을 반환한다.")
    @Test
    void getCountDuplication() {
        int result = lottoComparison.getCountDuplication();

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("주어진 객체의 보너스 번호 여부에 해당하는 값을 반환한다.")
    @Test
    void getCheckBonus() {
        boolean result = lottoComparison.getCheckBonus();

        assertThat(result).isEqualTo(true);
    }
}
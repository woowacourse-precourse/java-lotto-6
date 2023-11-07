package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.LottoResultStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        lottoResult.add(LottoResultStatus.THREE);
    }

    @DisplayName("총 수익률이 소수이면 소수점 아래 둘째자리에서 반올림된다.")
    @ParameterizedTest
    @CsvSource({"8000,62.5", "1000,500.0", "11000,45.5", "14000,35.7"})
    void roundRateOfReturn(int price, String expected) {
        String actual = lottoResult.roundRateOfReturn(PurchasePrice.from(price));
        assertThat(actual).contains(expected);
    }

    @DisplayName("총 수익률이 천 단위 이상이면 천 단위로 쉼표(,)가 붙는다.")
    @ParameterizedTest
    @CsvSource(value = {"10000/20,000,050.0", "220000/909,093.2"}, delimiter = '/')
    void markCommaByThreeDigit(int price, String expected) {
        lottoResult.add(LottoResultStatus.SIX);

        String actual = lottoResult.roundRateOfReturn(PurchasePrice.from(price));
        assertThat(actual).contains(expected);
    }
}

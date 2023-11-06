package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoSellingPolicyTest {
    LottoSellingPolicy lottoSellingPolicy = new LottoSellingPolicy();

    @DisplayName("구입 금액에 따라 살 수 있는 로또 갯수를 계산할 수 있다.")
    @ParameterizedTest(name = "투입 금액 : {0} , 구입 갯수 : {1}")
    @CsvSource(value = {"1000,1", "10000,10","15000,15"})
    void calcuateLottoCount(int money, int expectCountLotto) {
        BigDecimal purchasingMoney = new BigDecimal(money);
        int countLotto = lottoSellingPolicy.calcuateLottoCount(purchasingMoney);

        assertThat(countLotto).isEqualTo(expectCountLotto);
    }
}

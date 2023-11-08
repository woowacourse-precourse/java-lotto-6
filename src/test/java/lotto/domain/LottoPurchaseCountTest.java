package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoPurchaseCountTest {

    @ParameterizedTest
    @ValueSource(ints = {3000, 5000, 20000, 132000})
    @DisplayName("로또 발급 개수 구하기 테스트")
    void 로또_발급_개수_구하기(int lottoPurchaseAmount) {
        int lottoCount = lottoPurchaseAmount / 1000;
        int lottoCountCalculate = LottoPurchaseCount.calculate(lottoPurchaseAmount);

        assertThat(lottoCountCalculate).isEqualTo(lottoCount);
    }
}

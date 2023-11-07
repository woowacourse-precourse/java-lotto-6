package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoBuyerTest {
    @DisplayName("로또 구매 갯수 판단 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000})
    void 로또_구매_갯수_판단_테스트(int purchaseAmount) {
        LottoBuyer lottoBuyer = new LottoBuyer(purchaseAmount);
        int purchaseCount = lottoBuyer.purchaseCount();
        assertThat(purchaseCount).isEqualTo(purchaseAmount / 1000);
    }
}

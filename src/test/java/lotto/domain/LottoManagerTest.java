package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    private LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager();
    }

    @DisplayName("로또 구입 개수를 계산하는 기능 테스트")
    @Test
    void calculateNumberOfLottosTest() {
        int money = 2_000;
        int expectedAmount = 2;

        int lottoAmount = lottoManager.calculateNumberOfLottos(money);

        assertThat(lottoAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("1,000원 단위가 아닌 금액을 입력 시 예외 테스트")
    @Test
    void validatePurchaseAmountThrowsExceptionTest() {
        int money = 1_200;

        assertThatThrownBy(() -> lottoManager.validatePurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @DisplayName("1,000원 단위의 금액을 입력 시 예외 테스트")
    @Test
    void validatePurchaseAmountDoesNotThrowExceptionTest() {
        int money = 1_000;

        assertThatCode(() -> lottoManager.validatePurchaseAmount(money))
                .doesNotThrowAnyException();
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateProfitRate() {
        int money = 8_000;
        Prizes prizes = Prizes.createPrizes();
        prizes.increasePrizeAmount(Prize.FIFTH_PLACE);
        int totalPrize = prizes.calculateTotalPrize();
        double expectedRate = 62.5;

        double profitRate = lottoManager.calculateProfitRate(money, totalPrize);

        assertThat(profitRate).isEqualTo(expectedRate);
    }
}
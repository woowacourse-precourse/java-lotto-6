package lotto.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.config.ValidatorConfig;
import lotto.domain.valueobject.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class OrderTest {
    private static final String ERROR_MESSAGE = ValidatorConfig.ERROR_MESSAGE.getMessage();

    @DisplayName("유효성 검사")
    @Nested
    class validate {
        @DisplayName("1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
        @Test
        void createOrder() {
            assertThatThrownBy(() -> new Order(1200))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + "로또 구입 금액은 1000로 나누어 떨어져야 합니다.");
        }
    }

    @DisplayName("기능 확인")
    @Nested
    class 기능_확인 {
        private static final int PROPERTY = 5000;
        private static final int PRICE_PER_LOTTO = 1000;
        private Order order;

        @Mock
        Statistics mockStatistics;

        @BeforeEach
        void setUp() {
            order = new Order(PROPERTY);
        }

        @DisplayName("5000원을 구매하면 5장을 리턴 받는다.")
        @Test
        void getNumberOfPurchaseLotto() {
            int expectedNumberOfLottos = PROPERTY / PRICE_PER_LOTTO;

            int result = order.getNumberOfPurchaseLotto();

            assertThat(result).isEqualTo(expectedNumberOfLottos);
        }
    }
}
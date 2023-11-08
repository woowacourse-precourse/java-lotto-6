package lotto.domain;

import lotto.constant.message.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseTest {

    private LottoPurchase lottoPurchase;

    @BeforeEach
    void setUp() {
        lottoPurchase = new LottoPurchase();
    }

    @Test
    @DisplayName("입력받은 수를 1000으로 나눈값을 반환")
    void createLottoPurchaseWithAmount() {
        // given
        int purchaseMoney = 5000;

        // when
        lottoPurchase.LottoPurchaseCreat(purchaseMoney);

        // then
        assertThat(lottoPurchase.getAmount()).isEqualTo(5); // 5000을 1000으로 나누면 5가 되어야 합니다.
    }

    @Test
    @DisplayName("입력받은 리스트를 반환")
    void getUserLottoSetsPurchaseLotto() {
        // given
        List<Lotto> purchaseLotto = new ArrayList<>();

        // when
        lottoPurchase.getUserLotto(purchaseLotto);

        // then
        assertThat(lottoPurchase.getPurchaseLotto()).isSameAs(purchaseLotto);
    }

    @Test
    @DisplayName("입력받은 값이 1000으로 나누어떨어지지 않으면 예외 발생")
    void createLottoPurchaseWithInvalidAmount() {
        // given
        int purchaseMoney = 999;

        // when & then
        assertThatThrownBy(() -> lottoPurchase.LottoPurchaseCreat(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.PURCHASE_ERROR.getMessage());
    }
}
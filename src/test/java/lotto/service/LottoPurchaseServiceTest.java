package lotto.service;

import lotto.constant.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.exception.LottoException;
import lotto.exception.LottoStoreException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoPurchaseServiceTest {
    private LottoPurchaseService lottoPurchaseService;
    private static final String ERROR = "[ERROR]";

    @BeforeEach
    void beforeEach() {
        lottoPurchaseService = LottoPurchaseService.getInstance();
    }

    @Test
    @DisplayName("구매 금액이 로또 한 장의 금액보다 작을 때 예외 발생")
    void purchaseAutoLottosWithInsufficientMoney() {
        int insufficientMoney = LottoConstants.LOTTO_PRICE.getValue() - 1;
        assertThatThrownBy(() -> lottoPurchaseService.purchaseAutoLottos(insufficientMoney))
                .isInstanceOf(LottoStoreException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    @DisplayName("구매 금액이 로또 한 장의 금액과 같을 때 구매 가능")
    void purchaseAutoLottosWithExactMoney() throws LottoException {
        Lottos lottos = lottoPurchaseService.purchaseAutoLottos(LottoConstants.LOTTO_PRICE.getValue());
        assertThat(lottos.getSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("구매 금액이 로또 한 장의 금액보다 크며 로또 최대 금액보다 작을 때 구매 가능")
    void purchaseAutoLottosWithValidMoney() throws LottoException {
        int validMoney = LottoConstants.LOTTO_PRICE.getValue() * 10;
        Lottos lottos = lottoPurchaseService.purchaseAutoLottos(validMoney);
        assertThat(lottos.getSize()).isEqualTo(validMoney / LottoConstants.LOTTO_PRICE.getValue());
    }

    @Test
    @DisplayName("구매 금액이 로또 최대 금액보다 클 때 예외 발생")
    void purchaseAutoLottosWithExceedingMaxMoney() {
        int exceedingMoney = LottoConstants.MAX_LOTTO_PRICE_PER_USER.getValue() + 1;
        assertThatThrownBy(() -> lottoPurchaseService.purchaseAutoLottos(exceedingMoney))
                .isInstanceOf(LottoStoreException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    @DisplayName("구매 금액이 로또 한 장의 금액으로 나누어 떨어지지 않을 때 예외 발생")
    void purchaseAutoLottosWithNonDivisibleMoney() {
        int nonDivisibleMoney = LottoConstants.LOTTO_PRICE.getValue() + 1;
        assertThatThrownBy(() -> lottoPurchaseService.purchaseAutoLottos(nonDivisibleMoney))
                .isInstanceOf(LottoStoreException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    @DisplayName("수동 로또 구매 시 정상적으로 생성")
    void purchaseManualLotto() throws LottoException {
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6");
        Lotto lotto = lottoPurchaseService.purchaseManualLotto(numbers);

        assertThat(lotto).isNotNull();
        assertThat(lotto.getNumbers().size()).isEqualTo(LottoConstants.LOTTO_SIZE.getValue());
    }

    @Test
    @DisplayName("수동 로또 구매 시 로또 숫자가 부족해 예외 발생")
    void purchaseManualLottoWithNonSize() throws LottoException {
        List<String> numbers = List.of("1", "2", "3", "4", "5");

        assertThatThrownBy(() -> lottoPurchaseService.purchaseManualLotto(numbers))
                .isNotNull()
                .isInstanceOf(LottoException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}

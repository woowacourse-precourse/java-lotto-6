package lotto.domain.lotto;

import static lotto.util.ConstantUtils.*;
import static org.assertj.core.api.Assertions.*;

import lotto.domain.amount.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoMachine 클래스")
class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = LottoMachine.initial();
    }

    @Test
    @DisplayName("로또 기계는 구매 금액만큼 로또를 발급해야 한다.")
    void testPurchaseLottos() {
        int initialPurchaseAmount = 5000;
        PurchaseAmount purchaseAmount = PurchaseAmount.from(initialPurchaseAmount);

        Lottos lottos = lottoMachine.purchaseLottos(purchaseAmount);

        assertThat(initialPurchaseAmount / LOTTO_COST_CRITERION)
            .isEqualTo(lottos.size());
    }

    @Test
    @DisplayName("발급된 로또는 지정된 숫자 범위 내에서 중복되지 않는 유일한 번호로 구성돼야 한다")
    void testLottoNumberRange() {
        int initialPurchaseAmount = 1000;
        PurchaseAmount purchaseAmount = PurchaseAmount.from(initialPurchaseAmount);

        Lottos lottos = lottoMachine.purchaseLottos(purchaseAmount);
        Lotto lotto = lottos.asList().iterator().next();

        assertThat(
            lotto.getNumbers().stream().allMatch(number -> number >= 1 && number <= 45)).isTrue();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }
}

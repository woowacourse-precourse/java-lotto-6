package lotto.model;

import lotto.util.RandomLottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseLottosTest {
    private PurchaseLottos purchaseLottos;

    @BeforeEach
    void setPurchaseLottos() {
        RandomLottoMachine lottoMachine = new RandomLottoMachine();
        int purchaseAmount = 5000;
        purchaseLottos = new PurchaseLottos(lottoMachine, purchaseAmount);
    }

    @DisplayName("구입금액으로 5000원을 입력하였을 시 로또가 5장 생성된다.")
    @Test
    void setCountWithPurchaseAmount() {
        assertThat(purchaseLottos.getCount()).isEqualTo(5);
    }

    @DisplayName("랜덤 로또 머신으로 생성된 로또는 모두 다르다.")
    @Test
    void createNotDuplicatedLottos() {
        assertThat(purchaseLottos.getPurchaseLottos().stream().distinct().count()).isEqualTo(purchaseLottos.getCount());
    }
}

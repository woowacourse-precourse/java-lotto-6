package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseComputerTest {
    PurchaseComputer purchaseComputer = new PurchaseComputer();
    PurchaseRepository purchaseRepository = PurchaseRepository.getInstance();

    @DisplayName("한개당 1000원으로 계산하여 로또를 구매할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 50000})
    void getCountOfPurchasableLotto(int payment) {
        // given
        int count = purchaseComputer.getCountOfPurchasable(payment);
        // when & then
        Assertions.assertThat(count).isEqualTo(payment/1000);
    }

    @DisplayName("100원단위로 입력시 버려지고 계산한다.")
    @ParameterizedTest
    @ValueSource(ints = {1500, 2600, 3700, 4800, 50999})
    void getCountOfPurchasableLotto_백원단위_입력(int payment) {
        // given
        int count = purchaseComputer.getCountOfPurchasable(payment);
        // when & then
        Assertions.assertThat(count).isEqualTo(payment/1000);
    }

    @DisplayName("구입한 장수만큼 레포지토이에 저장된다.")
    @Test
    void purchaseAndStoreAtRepository() {
        // given
        List<Integer> purchases = List.of(1, 2, 3, 4, 5);
        for (int purchase : purchases) {
            purchaseComputer.purchaseLottoForCount(purchase);
        }

        // when & then
        Assertions.assertThat(purchaseRepository.size())
                .isEqualTo(purchases.stream().mapToInt(Integer::intValue).sum());
    }

}
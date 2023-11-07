package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchasedLottoTest {

    @DisplayName("여러 개의 로또를 샀을 때, 정상적으로 로또 개수를 증가시키는지")
    @Test
    void addLotto() {
        // given
        PurchasedLotto purchasedLotto = new PurchasedLotto();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        Integer initialSize = purchasedLotto.getLottos().size();

        // when
        purchasedLotto.addLotto(lotto1);
        purchasedLotto.addLotto(lotto2);

        // then
        Integer updatedSize = purchasedLotto.getLottos().size();
        assertEquals(2, updatedSize - initialSize);
    }
}
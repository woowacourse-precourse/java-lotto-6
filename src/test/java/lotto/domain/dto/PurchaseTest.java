package lotto.domain.dto;

import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {

    @Test
    void purchase_내부_필드가_동일하다면_같은_객체로_인식한다() {
        Lottos lottos = new Lottos();
        Purchase purchaseA = new Purchase(5, lottos);
        Purchase purchaseB = new Purchase(5, lottos);

        assertEquals(purchaseA, purchaseB);
    }

    @Test
    void purchase_내부_필드가_동일하다면_Hash_자료구조에서도_객체로_인식한다() {
        Set<Purchase> set = new HashSet<>();
        Lottos lottos = new Lottos();
        Purchase purchaseA = new Purchase(5, lottos);
        Purchase purchaseB = new Purchase(5, lottos);

        set.add(purchaseA);
        set.add(purchaseB);

        assertEquals(1, set.size());
    }
}

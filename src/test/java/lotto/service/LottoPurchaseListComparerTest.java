package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPurchaseListComparerTest {
    private LottoPurchaseListComparer comparer;

    @BeforeEach
    void setUp() {
        comparer = new LottoPurchaseListComparer();
    }

    @DisplayName("일치하는 번호 갯수에 따른 값을 반환한다.")
    @Test
    void testCompareUnitNumber() {
        List<Integer> purchaseUnit = Arrays.asList(1, 2, 3, 4, 5, 10);
        List<Integer> lotto = Arrays.asList(1, 3, 5, 7, 8, 9);
        int bonus = 10;

        int result = comparer.compareUnitNumber(purchaseUnit, lotto, bonus);
        assertEquals(3, result);
    }

    @DisplayName("당첨 번호와 보너스 번호를 조합해서 구매 로또 번호의 일치 여부를 계산한다.")
    @Test
    void testCompareBundle() {
        List<List<Integer>> purchase = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 45),
                Arrays.asList(3, 7, 8, 9, 10, 11),
                Arrays.asList(1, 3, 5, 7, 11, 10)
        );
        List<Integer> lotto = Arrays.asList(1, 3, 5, 7, 9, 11);
        int bonus = 10;

        comparer.compareBundle(purchase, lotto, bonus);
        List<Integer> resultList = comparer.getResultList();
        assertEquals(1, resultList.get(0));
        assertEquals(1, resultList.get(1));
        assertEquals(0, resultList.get(2));
        assertEquals(1, resultList.get(3));
        assertEquals(0, resultList.get(4));
    }
}


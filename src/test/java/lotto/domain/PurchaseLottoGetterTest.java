package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseLottoGetterTest {
    @DisplayName("6개의 숫자 리스트를 반환하는지 확인")
    @Test
    void counterByCorrectValue() {
        List<Integer> testList = new PurchaseLottoGetter().getRandomNumbers();
        int testSize = testList.size();

        assertThat(testSize).isEqualTo(6);
    }
}
package lotto.model;

import static lotto.util.ConstantNumbers.LOTTO_FIFTH_MONEY;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    Map<Integer, Integer> result;

    LottoResult lottoResult;

    @BeforeEach
    void reset() {
        result = new HashMap<>();
        result.put(0, 1);
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);
        result.put(4, 0);

        lottoResult = LottoResult.of(result);
    }

    @DisplayName("Key 입력시 Value 반환 확인")
    @Test
    void testLottoResult() {
        assertThat(lottoResult.getValue(3)).isEqualTo(0);
    }

    @DisplayName("로또 결과 총합 금액 계산")
    @Test
    void testCalculateTotal() {
        assertThat(lottoResult.calculateTotal()).isEqualTo(LOTTO_FIFTH_MONEY.getConstant());
    }
}
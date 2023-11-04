package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @DisplayName("Key 입력시 Value 반환 확인")
    @Test
    void testLottoResult() {
        //given
        Map<Integer, Integer> result = new HashMap<>();
        result.put(1, 1);
        result.put(2, 0);
        result.put(3, 0);
        result.put(4, 0);
        result.put(5, 0);

        //when
        LottoResult lottoResult = LottoResult.of(result);

        //then
        assertThat(lottoResult.getValue(3)).isEqualTo(0);
    }

}
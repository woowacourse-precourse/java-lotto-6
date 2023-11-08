package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 당첨 여부 확인 테스트")
    @Test
    void 로또_당첨_테스트() {
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        int count = lotto.countNumber(winNumbers);

        assertEquals(6, count);
    }
}

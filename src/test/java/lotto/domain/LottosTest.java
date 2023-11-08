package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @DisplayName("Lotto 생성한 뒤 개수 비교 테스트")
    @Test
    public void testCreateLotto() {
        // Given
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12)
        );
        // When
        Lottos lottos = new Lottos(numbers);
        // Then
        List<Lotto> lottoList = lottos.getLottos();
        assertEquals(2, lottoList.size());
    }

}
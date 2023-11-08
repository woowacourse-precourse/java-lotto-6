package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Lotto 테스트")
class LottoTest {

    @Test
    @DisplayName("로또 번호 유효성 검사")
    void testLottoValidation() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);

        assertDoesNotThrow(() -> new Lotto(validNumbers));
        assertThrows(LottoValidationException.class, () -> new Lotto(invalidNumbers));
    }

    @Test
    @DisplayName("로또 번호 일치 개수 확인")
    void testCountMatches() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.asList(3, 4, 5, 6, 7, 8);

        int matches = lotto.countMatches(winningNumbers);

        assertEquals(matches, 4);
    }

    @Test
    @DisplayName("로또 번호 포함 여부 확인")
    void testContains() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        assertTrue(lotto.contains(3));
        assertFalse(lotto.contains(7));
    }
}
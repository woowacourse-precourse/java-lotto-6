package lotto.util;

import static lotto.util.Constants.LOTTO_NUMBER_MAX_RANGE;
import static lotto.util.Constants.LOTTO_NUMBER_MIN_RANGE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new RandomLottoGenerator();
    }

    @Nested
    @DisplayName("로또 랜덤 생성 테스트")
    class RandomLottoGenerationTests {
        @Test
        @DisplayName("범위 유효 테스트")
        void 랜덤로또_범위검증() {
            List<Integer> lottoNumbers = lottoGenerator.generateNumber();

            assertTrue(lottoNumbers.stream()
                    .allMatch(number -> number >= LOTTO_NUMBER_MIN_RANGE && number <= LOTTO_NUMBER_MAX_RANGE));
        }

        @Test
        @DisplayName("최소값보다 작을때 예외 테스트")
        void 랜덤로또_최소범위미만() {
            List<Integer> lottoNumbers = lottoGenerator.generateNumber();

            assertFalse(lottoNumbers.stream().anyMatch(number -> number < LOTTO_NUMBER_MIN_RANGE));
        }

        @Test
        @DisplayName("최대값보다 클을때 예외 테스트")
        void 랜덤로또_최대범위초과() {
            List<Integer> lottoNumbers = lottoGenerator.generateNumber();

            assertFalse(lottoNumbers.stream().anyMatch(number -> number > LOTTO_NUMBER_MAX_RANGE));
        }
    }
}
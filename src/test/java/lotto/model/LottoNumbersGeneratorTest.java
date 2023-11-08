package lotto.model;

import static lotto.Constraints.SIZE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumbersGeneratorTest {
    LottoNumbersGenerator lottoNumbersGenerator;
    List<Integer> generatedLottoNumbers;

    @BeforeEach
    void setup() {
        lottoNumbersGenerator = new LottoNumbersGenerator();
        generatedLottoNumbers = lottoNumbersGenerator.generateLottoNumbers();
    }

    @Test
    @DisplayName("숫자 6개 검증")
    void validateSizeSixTest() {
        assertThat(generatedLottoNumbers.size()).isEqualTo(SIZE.getValue());
    }

    @Test
    @DisplayName("중복된 숫자 검증")
    void validateDuplicateNumberTest() {
        HashSet<Integer> uniqueLottoNumbers = new HashSet<>(generatedLottoNumbers);
        assertEquals(SIZE.getValue(), uniqueLottoNumbers.size());
    }

    @Test
    @DisplayName("오름차순 정렬 검증")
    void validateAscendingSortTest() {
        for (int index = 0; index < generatedLottoNumbers.size() - 1; index++) {
            assertTrue(generatedLottoNumbers.get(index) < generatedLottoNumbers.get(index + 1));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("count 개수만큼 Lotto 생성")
    void generateLottoAsCountTest(int count) {
        List<Lotto> lottos = lottoNumbersGenerator.generateLottos(count);
        assertEquals(lottos.size(), count);
    }
}
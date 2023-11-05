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
    void validateSizeSix() {
        assertThat(generatedLottoNumbers.size()).isEqualTo(SIZE.getValue());
    }

    @Test
    @DisplayName("중복된 숫자 검증")
    void validateDuplicateNumber() {
        HashSet<Integer> uniqueLottoNumbers = new HashSet<>(generatedLottoNumbers);
        assertEquals(SIZE.getValue(), uniqueLottoNumbers.size());
    }

    @Test
    @DisplayName("오름차순 정렬 검증")
    void validateAscendingSort() {
        for (int index = 0; index < generatedLottoNumbers.size() - 1; index++) {
            assertTrue(generatedLottoNumbers.get(index) < generatedLottoNumbers.get(index + 1));
        }
    }
}
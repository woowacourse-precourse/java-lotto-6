package lotto.domain;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoNumberGeneratorTest {

    @Test
    void generateLottoNumbers() {
        // Given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        // When
        List<Integer> generatedNumbers = lottoNumberGenerator.generateLottoNumbers();

        // Then
        assertTrue(generatedNumbers.size() == LottoConstant.LOTTO_NUMBER_COUNT.getValue(),
                ErrorMessage.SIZE_OF_LOTTO_NUMBERS_LIST_MUST_BE_6.getMessage());

        assertTrue(generatedNumbers.stream().allMatch(num -> num >= LottoConstant.MIN_LOTTO_NUMBER.getValue()
                        && num <= LottoConstant.MAX_LOTTO_NUMBER.getValue()),
                ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());

        System.out.println(generatedNumbers);
    }
}

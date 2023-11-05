package lotto.model.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.model.domain.exception.LottoGameConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    @DisplayName("로또_번호가_제대로_생성_되었는지")
    void generateLottoNumbers() {
        // arrange
        int lottoSize = LottoGameConstants.NUMBERS_PER_LOTTO.getValue();
        int minRange = LottoGameConstants.MIN_NUMBER.getValue();
        int maxRange = LottoGameConstants.MAX_NUMBER.getValue();

        // act
        List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();

        // assert
        assertThat(lottoNumbers).isNotNull()
                .size()
                .isEqualTo(lottoSize);
        for (int number : lottoNumbers) {
            assertThat(number >= minRange && number <= maxRange)
                    .isTrue();
        }
    }
}
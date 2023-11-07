package lotto.system.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {
    @DisplayName("1부터 45 사이의 수 6개를 중복없이 뽑는다.")
    @ParameterizedTest(name = "{0}부터 {1}까지의 개수는 {2} 이다.")
    @CsvSource(value = {"1,45,6"}, delimiter = ',')
    public void 로또_번호_생성(int minNumber, int maxNumber, int expectedSize) {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        // when
        List<Integer> generatedNumbers = lottoNumberGenerator.generate();

        // then
        assertAll(
                "6개의 로또 번호가 모두 1부터 45까지의 수이며 중복없음 확인",
                () -> assertThat(generatedNumbers)
                        .hasSize(expectedSize)
                        .allMatch(number -> number >= minNumber && number <= maxNumber),
                () -> assertThat(generatedNumbers)
                        .doesNotHaveDuplicates()
        );
    }
}
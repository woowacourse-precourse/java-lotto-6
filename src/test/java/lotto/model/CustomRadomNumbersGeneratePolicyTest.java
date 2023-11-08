package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomRadomNumbersGeneratePolicyTest {
    CustomRadomNumbersGeneratePolicy radomNumbersGeneratePolicy = new CustomRadomNumbersGeneratePolicy();

    @DisplayName("발행한 로또 범위의 6개의 숫자는 중복되지 않으며 1~45사이의 범위를 만족한다.")
    @Test
    void generateRandomNumbers() {
        List<Integer> generatedNumbers = radomNumbersGeneratePolicy.generate();

        assertThat(generatedNumbers)
                .allMatch(this::isProperLottoNumber)
                .doesNotHaveDuplicates();
    }

    private boolean isProperLottoNumber(int number) {
        return 1 <= number && number <= 45;
    }
}

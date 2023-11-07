package lotto;

import lotto.model.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberGeneratorTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void generateLottoNumbers() {
        NumberGenerator numberGenerator = new NumberGenerator();

        List<Integer> lottoNumbers = numberGenerator.getNumber();

        assertThat(lottoNumbers)
                .isNotNull()
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allSatisfy(number -> assertThat(number).isBetween(1, 45));

        assertThat(lottoNumbers).isSorted();
    }
}

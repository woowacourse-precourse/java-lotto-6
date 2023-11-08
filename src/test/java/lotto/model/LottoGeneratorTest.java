package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {
    @DisplayName("음수 값 수량 생성시 예외가 발생한다.")
    @Test
    void negativeAmountGenerate() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        assertThatThrownBy(() -> lottoGenerator.generate(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("적절한 수량 생성시 해당 개수만큼 lotto가 생성된다.")
    @Test
    void generateNormal() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        lottoGenerator.generate(10);
        assertThat(lottoGenerator.getLottos().size()).isEqualTo(10);
    }
}

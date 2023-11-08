package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @DisplayName("로또 생성기가 로또 객체를 생성하는지 테스트")
    @Test
    void 로또_생성_테스트() {
        // given
        LottoRandomGenerator lottoRandomGenerator = new LottoRandomGenerator();

        // when & then
        assertThat(lottoRandomGenerator.generate())
                .isInstanceOf(Lotto.class);
    }
}

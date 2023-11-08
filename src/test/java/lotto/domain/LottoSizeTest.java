package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoSizeTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000"})
    void 사이즈_출력(String size) {
        LottoSize lottoSize = new LottoSize(Integer.parseInt(size));
        Assertions.assertThat(lottoSize.toString())
                .isEqualTo(size);
    }
}

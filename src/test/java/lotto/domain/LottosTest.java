package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.AutoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottosTest {
    @DisplayName("주어진 개수만큼 로또가 생성된다.")
    @ParameterizedTest
    @CsvSource({"1", "5", "100"})
    void getLottosBycount(int count) {
        Lottos lottos = Lottos.of(count, new AutoGenerator());
        int actual = lottos.getLottosSize();
        assertThat(actual).isEqualTo(count);
    }
}

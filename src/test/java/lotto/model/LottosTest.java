package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.generator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @DisplayName("숫자 생성기를 사용하여 로또 묶음이 정확히 생성되는지 확인한다.")
    @Test
    void createLottosFromValidInput() {
        NumberGenerator mockNumberGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
        Lottos lottos = Lottos.assemble(mockNumberGenerator, 3);

        List<Lotto> expectedLottos = List.of(
                Lotto.issue(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.issue(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.issue(List.of(1, 2, 3, 4, 5, 6))
        );

        assertThat(lottos.getLottos()).containsExactlyInAnyOrderElementsOf(expectedLottos);
    }
}

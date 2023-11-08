package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @DisplayName("lottos 생성 테스트")
    @Test
    void makeLottosTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.makeLotto(List.of(10, 11, 12, 13, 14, 15)));
        lottos.add(Lotto.makeLotto(List.of(20, 21, 22, 23, 24, 25)));
        Lottos lottosTest = Lottos.makeLottos(lottos);
        assertThat(lottos).isEqualTo(lottosTest.getLottos());
    }
}

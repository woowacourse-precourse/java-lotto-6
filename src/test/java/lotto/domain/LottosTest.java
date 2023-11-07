package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {

    @Test
    void Lottos생성_및_필드값_사이즈_확인() {
        List<Lotto> lottos =
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                , new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                , new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lottos purchasedLottos = new Lottos(lottos);
        assertThat(purchasedLottos.getLottos().size()).isEqualTo(3);
    }
}

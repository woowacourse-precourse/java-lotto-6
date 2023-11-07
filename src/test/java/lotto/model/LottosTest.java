package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @DisplayName("Lottos 생성자 테스트")
    @Test
    void createLottos() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(10,11,12,13,14,15));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);

        Lottos result = new Lottos(lottos);

        assertThat(result.getSize()).isEqualTo(2);
    }
}
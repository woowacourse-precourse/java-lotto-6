package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    @DisplayName("로또를 생성한다.")
    @Test
    void createLottos() {
        final int money = 3000;
        final List<Lotto> lottos = LottoManager.createLottos(money);
        lottos.forEach(System.out::println);

        assertThat(lottos.size()).isEqualTo(3);
    }
}
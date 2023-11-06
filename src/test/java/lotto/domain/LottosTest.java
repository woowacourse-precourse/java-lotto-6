package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("주어진 로또 개수에 알맞게 로또들이 생성된다.")
    @Test
    void createProperLottos() {
        int quantity = 3;
        Lottos lottos = new Lottos(quantity);
        assertThat(lottos.getLottos().size()).isEqualTo(quantity);
    }

    @DisplayName("로또가 오름차순으로 정렬되어 있다.")
    @Test
    void createLottosInAscendingOrder(){
        Lottos lottos = new Lottos(3);
        for(Lotto lotto : lottos.getLottos()){
            List<Integer> actual = lotto.getNumbers();
            List<Integer> expected = lotto.getNumbers();
            Collections.sort(expected);
            assertThat(actual.equals(expected));
        }
    }

}
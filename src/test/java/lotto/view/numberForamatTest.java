package lotto.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

class numberForamatTest {
    Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
    Lotto lotto2 = new Lotto(List.of(4,5,6,1,2,3));
    Lottos lottos = new Lottos(List.of(lotto, lotto2));
    @Test
    void 로또_번호_포맷팅_테스트() {
        assertThat(numberForamat.makeFormat(lottos)).isEqualTo("[1, 2, 3, 4, 5, 6]\n[4, 5, 6, 1, 2, 3]");
    }

}
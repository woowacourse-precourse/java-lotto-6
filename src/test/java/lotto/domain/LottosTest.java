package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @DisplayName("로또 번호 목록을 반환한다.")
    @Test
    void getLottos() {
        //given
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(1,2,3,4,5,7))));
        //when
        List<Lotto> lottoGroup = lottos.getLottos();
        //then
        assertThat(lottoGroup).hasSize(2)
                .extracting("numbers")
                .containsExactly(
                        List.of(1,2,3,4,5,6),
                        List.of(1,2,3,4,5,7)
                );
    }

    @DisplayName("로또 목록의 개수를 반환한다.")
    @Test
    void size() {
        //given
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(1,2,3,4,5,7))));
        //when
        int size = lottos.size();
        //then
        assertThat(size).isEqualTo(2);
    }
}
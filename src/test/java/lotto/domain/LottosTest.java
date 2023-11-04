package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("로또 모음에 로또가 잘 들어가는지 확인")
    void add() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
    }

    @Test
    @DisplayName("로또 모음에 정확한 수의 로또가 들어 갔는지 확인")
    void Given_lottos_When_addThreeLotto_Then_lottosSizeIsThree() {
        // given
        Lottos lottos = new Lottos();
        // when
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        // then
        assertThat(lottos.size()).isEqualTo(3);
    }
}
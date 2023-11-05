package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    void LottosAddTest() {
        //given
        Lotto lotto =  new Lotto(Arrays.asList(3, 4, 2, 6, 5, 1));
        Lottos lottos = new Lottos();

        //when
        lottos.addLotto(lotto);

        //then
        Assertions.assertThat(lottos.getLottosSize()).isEqualTo(1);
    }

}
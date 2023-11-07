package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LottosTest {

    @Test
    void LottosAddTest() {
        //given
        Lotto lotto =  new Lotto(new ArrayList<>(Arrays.asList(3, 4, 2, 6, 5, 1)));
        Lottos lottos = new Lottos();

        //when
        lottos.addLotto(lotto);

        //then
        Assertions.assertThat(lottos.getLottosSize()).isEqualTo(1);
    }

    @Test
    void printNumbers() {
        //given
        Lottos lottos = new Lottos();
        Lotto lotto1 =  new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(13, 24, 32, 36, 40, 41)));

        //when
        lottos.addLotto(lotto1);
        lottos.addLotto(lotto2);

        List<String> numbers = lottos.printNumbers(lottos.getLottosSize());

        //then
        Assertions.assertThat(numbers.get(0)).isEqualTo("1, 2, 3, 4, 5, 6");
        Assertions.assertThat(numbers.get(1)).isEqualTo("13, 24, 32, 36, 40, 41");
    }

}
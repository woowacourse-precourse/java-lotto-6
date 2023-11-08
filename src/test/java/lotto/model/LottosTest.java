package lotto.model;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottosTest {
    @Test
    public void 로또묶음_생성_테스트() {
        //given
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(9,10,16,25,31,40));
        Lotto lotto3 = new Lotto(List.of(1,11,33,23,44,7));
        String expectResult = "[1, 2, 3, 4, 5, 6]\n" +
                "[9, 10, 16, 25, 31, 40]\n" +
                "[1, 7, 11, 23, 33, 44]\n";
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3));

        //when
        String result = lottos.toString();
        int size = lottos.getSize();

        //then
        Assertions.assertThat(result).isEqualTo(expectResult);
        Assertions.assertThat(size).isEqualTo(3);
    }
}

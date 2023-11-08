package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class LottosTest {
    @DisplayName("로또 반복자 테스트")
    @Test
    void LottosIteratorTest() {
        //given
        Lottos lottos = new Lottos();

        //when
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(7, 8, 9, 10, 11, 12);
        lottos.add(numbers1);
        lottos.add(numbers2);

        //then
        Iterator<Lotto> lottoIterator = lottos.iterator();
        assertEquals(numbers1, lottoIterator.next().getNumbers());
        assertEquals(numbers2, lottoIterator.next().getNumbers());
    }
}
package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("로또 반복자 테스트")
    void Lottos_Iterator_test() throws Exception {
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
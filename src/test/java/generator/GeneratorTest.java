package generator;

import enums.Prize;
import lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    @DisplayName("빈 hashMap을 만든다.")
    void testMakeEmpty() {
        HashMap<Prize, Integer> result = Generator.makeEmpty();

        HashMap<Prize, Integer> expected = new HashMap<>() {{
            put(Prize.FIRST, 0);
            put(Prize.SECOND, 0);
            put(Prize.THIRD, 0);
            put(Prize.FOURTH, 0);
            put(Prize.FIFTH, 0);
        }};
        assertEquals(result, expected);
    }

    @Test
    @DisplayName("구입한 갯수만큼 lotto를 만든다.")
    void testMakeLottos() {
        int lotteryAmount = 5;
        List<Lotto> lottos = Generator.makeLottos(lotteryAmount);

        assertEquals(lotteryAmount, lottos.size());
    }

    @Test
    @DisplayName("makeRankings로 1-5등 로또가 몇개인지 알 수 있다")
    void testMakeRankings() {
        //given
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,7,20));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,4,7,8));
        List<Lotto> lottos = new ArrayList<Lotto>();
        lottos.add(lotto1);
        lottos.add(lotto2);
        List<Integer> winningLotto = new ArrayList<Integer>(Arrays.asList(1,2,3,4,7,8));
        int bonusNum = 20;

        //when
        HashMap<Prize, Integer> result = Generator.makeRankings(lottos, winningLotto, bonusNum);

        //then
        assertEquals(result.get(Prize.FIRST), 1);
        assertEquals(result.get(Prize.SECOND), 1);
        assertEquals(result.get(Prize.THIRD), 0);
        assertEquals(result.get(Prize.FOURTH), 0);
        assertEquals(result.get(Prize.FIFTH), 0);
    }

}
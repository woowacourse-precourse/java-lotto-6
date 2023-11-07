package lotto.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PrizesTest {

    @Test
    @DisplayName("Prizes는 등수를 모두 출력해주어야 한다.")
    void Prizes_등수_출력_정상작동() {
        List<Prize> list = new ArrayList<>();
        list.add(Prize.FIFTH);
        list.add(Prize.FIFTH);
        list.add(Prize.FIRST);
        list.add(Prize.SECOND);
        Prizes prizes = new Prizes(list);

        Map<Prize, Long> map = prizes.countPrizes();

        assertEquals(2, map.get(Prize.FIFTH));
        assertEquals(1, map.get(Prize.FIRST));
        assertEquals(1, map.get(Prize.SECOND));
    }

    @Test
    @DisplayName("Prizes는 등수를 모두 출력해주어야 한다.")
    void Prizes_등수_출력_정상작동_1위만4개() {
        List<Prize> list = new ArrayList<>();
        list.add(Prize.FIRST);
        list.add(Prize.FIRST);
        list.add(Prize.FIRST);
        list.add(Prize.FIRST);
        Prizes prizes = new Prizes(list);

        Map<Prize, Long> map = prizes.countPrizes();

        assertEquals(4, map.get(Prize.FIRST));
    }

    @Test
    @DisplayName("Prizes는 등수를 총 금액을 출력해주어야 한다")
    void Prizes_상금_출력_10000() {
        List<Prize> list = new ArrayList<>();
        list.add(Prize.FIFTH);
        list.add(Prize.FIFTH);
        Prizes prizes = new Prizes(list);

        assertEquals(10000, prizes.sumProfit());
    }

    @Test
    @DisplayName("Prizes는 등수를 총 금액을 출력해주어야 한다")
    void Prizes_상금_출력_1등() {
        List<Prize> list = new ArrayList<>();
        list.add(Prize.FIRST);
        Prizes prizes = new Prizes(list);

        assertEquals(2000000000, prizes.sumProfit());
    }
}
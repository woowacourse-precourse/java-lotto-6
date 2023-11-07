package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintTest extends Print{

    @Test
    void 오름차순_정렬() {

        //given
        Lotto lotto = new Lotto(List.of(42, 23, 8, 21, 43, 30));

        //when
        List<Integer> result = sort(lotto);

        //then
        System.out.println();
        assertThat(result).containsExactly(8, 21, 23, 30, 42, 43);
    }

    @Test
    void 수익률_계산() {

        //given
        int money = 8000;
        Map<Rank, Integer> drawResult = initDrawResult();
        drawResult.put(Rank.FIFTH, 1);

        //when
        String result = calculateProfitRatio(money, drawResult);

        //then
        assertThat(result).isEqualTo("62.5");
    }

    private Map<Rank, Integer> initDrawResult() {
        Map<Rank, Integer> drawResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            drawResult.put(rank, 0);
        }
        return drawResult;
    }
}

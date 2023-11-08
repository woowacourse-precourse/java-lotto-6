package lotto.domain;

import static lotto.domain.WinningDetails.findRanking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningDetailsTest {
    @Test
    void 등수가_정상적으로_출력되어야한다() {

        List<List<Integer>> randomLottos = new ArrayList<>();
        randomLottos.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        randomLottos.add(Arrays.asList(1, 2, 3, 4, 5, 7));
        randomLottos.add(Arrays.asList(1, 2, 3, 4, 5, 8));

        List<Integer> result = findRanking(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), randomLottos, 7);
        Assertions.assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }
}
package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinResultTest {
    @Test
    void getResultTest() {
        List<Lotto> allLotto = new ArrayList<>(Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)), //0
                new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)),  //5
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), //1
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)),  //3
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), //2
                new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)), //4
                new Lotto(Arrays.asList(1, 2, 3, 11, 12, 33))  //5
        ));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(WinResult.getResult(allLotto, winningLotto, 7)).isEqualTo(Arrays.asList(0, 5, 1, 3, 2, 4, 5));
    }

    @Test
    void countRankTest() {
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 5, 1, 3, 2, 4, 5));
        assertThat(WinResult.countRank(result)).isEqualTo(Arrays.asList(1, 1, 1, 1, 2));
    }
}
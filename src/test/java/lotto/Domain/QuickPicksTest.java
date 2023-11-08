package lotto.Domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class QuickPicksTest {

    @Test
    void lottoNumOrganize() {
        List<Integer> sixBalls = List.of(1,2,4,3,5,6);

        List<Integer> expected = List.of(1,2,3,4,5,6);
        List<Integer> actual  =QuickPicks.lottoNumOrganize(sixBalls);

        assertEquals(expected, actual);
    }


}
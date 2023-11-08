package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Prize;
import lotto.model.PrizeStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeStorgeTest {
    private PrizeStorage prizeStorage;

    @BeforeEach
    public void setUp() {
        List<Prize> prizes = Arrays.asList(
                Prize.FIRST, Prize.SECOND, Prize.THIRD,
                Prize.FIFTH, Prize.FIFTH, Prize.FIFTH
                );
        prizeStorage = new PrizeStorage(prizes);
    }

    @DisplayName("각 상금의 개수를 반환한다.")
    @Test
    public void getPrizeCountTest() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 3, 0));
        List<Integer> actual = prizeStorage.getPrizeCount();
        assertEquals(expected, actual);
    }
}

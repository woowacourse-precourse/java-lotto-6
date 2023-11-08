package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerTest {

    @DisplayName("두 로또 비교결과는 5등이다.")
    @Test
    void fifthPrizeTest() {
        Winner winner = new Winner();
        winner.checkLottoNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(6, 7, 8, 9, 10, 11), 1);
        assertEquals(1, winner.getResult().get(1));
    }

    @DisplayName("두 로또 비교결과는 2등이다.")
    @Test
    void secondPrizeTest() {
        Winner winner = new Winner();
        winner.checkLottoNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7), 6);
        assertEquals(1, winner.getResult().get(7));
    }

    @DisplayName("두 로또 비교결과는 1등이다.")
    @Test
    void firsetPrizeTest() {
        Winner winner = new Winner();
        winner.checkLottoNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7);
        assertEquals(1, winner.getResult().get(6));
    }

}

package lotto.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3, 4, 5, 6);
    private static final int BONUS_NUMBER = 7;


    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void testCompare() {
        Referee referee1 = new Referee(ANSWER, BONUS_NUMBER);
        int result1 = referee1.compare(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(6, result1);
        System.out.println(result1 + " " + referee1.getBonusNumber());
        Referee referee3 = new Referee(ANSWER, BONUS_NUMBER);
        int result3 = referee3.compare(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertEquals(5, result3);
        System.out.println(result3 + " " + referee3.getBonusNumber());
        Referee referee4 = new Referee(ANSWER, BONUS_NUMBER);
        int result4 = referee4.compare(Arrays.asList(1, 2, 3, 4, 5, 13));
        assertEquals(5, result4);
        System.out.println(result4 + " " + referee4.getBonusNumber());
    }
}

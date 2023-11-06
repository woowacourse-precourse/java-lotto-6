package lotto.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3, 4, 5, 6);
    private static final int BONUS_NUMBER = 7;
    private Referee referee;

    private static final List<Integer> lottoPlayer1 = Arrays.asList(1, 2, 3, 4, 5, 6);
    private static final List<Integer> lottoPlayer2 = Arrays.asList(7, 8, 9, 10, 11, 12);
    private static final List<Integer> lottoPlayer3 = Arrays.asList(1, 3, 5, 7, 9, 11);

    @BeforeEach
    void setUp() {
        final List<Integer> answerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;
        referee = new Referee(answerNumbers, bonusNumber);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void testCompare(){
        int result1 = Referee.compare(ANSWER, lottoPlayer1, BONUS_NUMBER);
        int result2 = Referee.compare(ANSWER, lottoPlayer2, BONUS_NUMBER);
        int result3 = Referee.compare(ANSWER, lottoPlayer3, BONUS_NUMBER);

        assertEquals(6, result1);
        assertEquals(0, result2);
        assertEquals(3, result3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

}
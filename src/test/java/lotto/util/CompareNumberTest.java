package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CompareNumberTest {
    private CompareNumber compareNumber;
    private MakeTestRandomNumber makeTestRandomNumber;

    @BeforeEach
    void setUp() {
        compareNumber = new CompareNumber();
        makeTestRandomNumber = new MakeTestRandomNumber(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("사용자 입력 당첨 번호와 실제 당첨 번호 비교 해서 수 출력")
    void compareWinnerNumber() {
        //given
        List<Integer> userWin = Arrays.asList(1, 3, 9, 18, 30, 45);
        List<Integer> randomWin = makeTestRandomNumber.getRandomNumber();
        //when
        int result = compareNumber.compareWinnerNum(userWin, randomWin);
        //then
        assertEquals(result, 2);
    }

    @Test
    @DisplayName("사용자 입력 보너스 번호와 실제 당첨 번호 리스트 비교 해서 수 출력")
    void compareBonusNumber() {
        //given
        int bonusNumber = 1;
        List<Integer> randomWin = makeTestRandomNumber.getRandomNumber();
        //when
        boolean result = compareNumber.compareBonusNum(bonusNumber, randomWin);
        //then
        assertTrue(result);
    }

}
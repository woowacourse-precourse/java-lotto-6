package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareNumberTest {
    private CompareNumber compareNumber;

    @BeforeEach
    void setUp(){
        CompareNumber compareNumber = new CompareNumber();
    }

    @Test
    @DisplayName("사용자 입력 당첨 번호와 실제 당첨 번호 비교 해서 수 출력")
    void compareWinnerNumber(){
        //given
        List<Integer> userWin = Arrays.asList(1,3,9,18,30,45);
        List<Integer> randomWin = (List<Integer>) new MakeTestRandomNumber(List.of(1,2,3,4,5,6));
        //when
        int result = compareNumber.compareWinnerNum(userWin,randomWin);
        //then
        assertEquals(result, 2);
    }

    @Test
    @DisplayName("사용자 입력 보너스 번호와 실제 당첨 번호 비교 해서 수 출력")
    void compareBonusNumber(){
        //given
        //when
        //then
    }

}
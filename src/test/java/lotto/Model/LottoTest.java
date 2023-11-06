package lotto.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class LottoTest {
    private List<Integer> validNumbers;
    private List<Integer> invalidNumbers;
    private List<Integer> invalidLengthNumbers;
    @BeforeEach
    void init(){
        validNumbers = Arrays.asList(10,20,25,30,40,45);
        invalidNumbers = Arrays.asList(10,20,20,30,40,45);
        invalidLengthNumbers = Arrays.asList(10,20,35,30,40,43,45);


    }
    @Test
    void 중복값_검증_참(){
        Lotto lotto = new Lotto(validNumbers);
    }

    @Test
    void 중복값_검증_거짓(){
        assertThrows(IllegalArgumentException.class,() -> new Lotto(invalidNumbers));
    }

    @Test
    void 길이가_7인_리스트(){
        assertThrows(IllegalArgumentException.class,() -> new Lotto(invalidLengthNumbers));
    }

    @Test
    void 리스트_정렬(){
        List<Integer> unsortedNumbers = Arrays.asList(11,34,12,45,13,23);
        List<Integer> sortedNumbers = Arrays.asList(11,12,13,23,34,45);
        assertEquals(sortedNumbers, Lotto.sortLottoNumber(unsortedNumbers));
    }

    @Test
    void 당첨개수세기(){
        List<Integer> winningNumbers = Arrays.asList(1,2,5,6,23,43);
        List<Integer> numbers = Arrays.asList(1,2,6,3,8,43);
        assertEquals(4,Lotto.getWinningNumberCount(winningNumbers,numbers));
    }

    @Test
    void 보너스번호당첨여부(){
        List<Integer> nums = Arrays.asList(10,20,30,40,44,45);
        int bonusNumber = 30;
        assertTrue(Lotto.isMatchBonusNumber(nums,bonusNumber));
        bonusNumber= Integer.parseInt("23");
        assertFalse(Lotto.isMatchBonusNumber(nums,bonusNumber));
    }
}
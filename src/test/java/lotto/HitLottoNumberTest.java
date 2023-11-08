package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.HitLottoNumber.*;

public class HitLottoNumberTest {
    @DisplayName("로또 번호와 당첨 번호가 동일하면 1이 리턴되는지 확인")
    @Test
    void hitLottoNumberTest(){
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        ArrayList<Integer> prizeNumberArray = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int bonusIntNumber = 7;

        int prizeNumber = hitLottoNumber(lotto,prizeNumberArray,bonusIntNumber);
        Assertions.assertThat(prizeNumber).isEqualTo(1);
    }

    @DisplayName("당첨 숫자 개수가 제대로 계산되는지 확인")
    @Test
    void countMatcingNumbersTest(){
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        ArrayList<Integer> prizeNumberArray = new ArrayList<>(Arrays.asList(1,2,3,4,5,7));

        int prizeSum = countMatchingNumbers(lotto, prizeNumberArray);
        Assertions.assertThat(prizeSum).isEqualTo(5);
    }

    @DisplayName("보너스 숫자가 일치하면 2를 리턴하고 일치하지 않으면 3을 리턴하는지 확인")
    @Test
    void checkWinWithBonusTest(){
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int bonusIntNumber1 = 6;

        int bonusCheckNumber1 = checkWinWithBonus(lotto, bonusIntNumber1);
        Assertions.assertThat(bonusCheckNumber1).isEqualTo(2);

        int bonusIntNumber2 = 7;
        int bonusCheckNumber2 = checkWinWithBonus(lotto, bonusIntNumber2);
        Assertions.assertThat(bonusCheckNumber2).isEqualTo(3);

    }
}

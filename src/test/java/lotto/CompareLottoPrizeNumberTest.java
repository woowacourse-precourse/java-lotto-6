package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static lotto.CompareLottoToPrizeNumber.winLottoToPrizeNumber;

public class CompareLottoPrizeNumberTest {
    @DisplayName("당첨 로또의 개수가 제대로 저장되는지 확인")
    @Test
    void winLottoToPrizeNumberTest(){
        ArrayList<Integer> prizeNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        ArrayList<List<Integer>> totalLotto = new ArrayList<>();
        totalLotto.add(Arrays.asList(1,2,3,4,5,6));
        int bonusNumber = 7;
        HashMap<Integer, Integer> winHashTable = winLottoToPrizeNumber(prizeNumber, totalLotto, bonusNumber);
        int firstWin = winHashTable.get(1);
        Assertions.assertThat(firstWin).isEqualTo(1);
    }
}

package lotto;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinResultTest {

    @DisplayName("로또가 주어졌을 때의 당첨 집계 결과에 대한 테스트")
    @Test
    void 당첨_집계_결과_테스트() {
        //given
        String[] winNums = {"1", "2", "3", "4", "5", "6"};
        WinNumbers winNumbers = new WinNumbers(winNums);
        BonusNumber bonusNumber = new BonusNumber("7");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        Lotto lotto = new Lotto(numbers);
        WinResult winResult = new WinResult();
        //when
        Rankings ranking = Rating.ranking(lotto.getLotto(), winNumbers.getWinNumbers(), bonusNumber.getBonusNumber());
        winResult.setWinResult(ranking);
        //then
        assertThat(winResult.getWinResult()
                .get(Rankings.SECOND)).isEqualTo(1);
    }
}

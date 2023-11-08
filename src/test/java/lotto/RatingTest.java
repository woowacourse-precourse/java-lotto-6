package lotto;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class RatingTest {

    @DisplayName("보너스 번호, 당첨 번호, 로또 번호가 주어질 때 이에 따른 랭킹을 보여준다")
    @Test
    void 랭킹_반환_테스트() {
        // given
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

        // when
        Rankings ranking = Rating.ranking(lotto.getLotto(), winNumbers.getWinNumbers(), bonusNumber.getBonusNumber());

        //then
        assertThat(ranking).isEqualTo(Rankings.SECOND);
    }
}

package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.RunnerLotto.makeAllLottoPaper;
import static org.junit.jupiter.api.Assertions.*;

class RunnerLottoTest {
    @DisplayName("만들고자 하는 임의의 로또 개수만큼의 로또 용지가 만들어져야 한다")
    @Test
    void checkAllOfLottoPapers(){
        int NumberOfLottoForTest=3;
        int expectedAllOfLottoPaepersNumber=3;
        assertEquals(expectedAllOfLottoPaepersNumber, makeAllLottoPaper(NumberOfLottoForTest).size());
    }
}
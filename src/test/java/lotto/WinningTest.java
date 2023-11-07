package lotto;

import lotto.model.Winning;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningTest {

    @DisplayName("값들 다 꺼내기")
    @Test
    void checkAllValues() {
        //given
        int count = 5;

        //when
        Winning[] allValues = Winning.values();

        //then
        Assertions.assertThat(allValues.length).isEqualTo(count);

    }

    @DisplayName("수익 계산해 보기")
    @Test
    void checkTotalMoney() {
        //given
        int count = 3;

        //when
        Winning winning = Winning.FIFTH;

        //then
        Assertions.assertThat(winning.calculateMoney(count)).isEqualTo(15000);

    }


}

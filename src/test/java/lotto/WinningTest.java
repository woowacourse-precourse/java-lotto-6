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
}

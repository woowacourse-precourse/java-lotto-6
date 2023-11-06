package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SplitTest {

    @DisplayName("쉼표(,)를 기준으로 구분하는 기능을 검증한다.")
    @Test
    void validateSplitCommas() {
        //given
        String userWinningNumber = "1,2,3";

        //when
        List<String> splitUserWinningNumber = new Split(userWinningNumber).getListValue();

        //then
        Assertions.assertThat(splitUserWinningNumber.get(0)).isEqualTo("1");
        Assertions.assertThat(splitUserWinningNumber.get(1)).isEqualTo("2");
        Assertions.assertThat(splitUserWinningNumber.get(2)).isEqualTo("3");
    }
}

package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class StringUtilTest {

    @Test
    void stringToInt() {
        // given
        String inputValue = "5000";

        // when
        int purchaseAmount = StringUtil.stringToInt(inputValue);

        // then
        Assertions.assertThat(purchaseAmount).isEqualTo(5000);
    }
}
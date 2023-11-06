package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class StringUtilTest {

    @DisplayName("구입 금액 문자열을 int 값으로 변환한다.")
    @Test
    void stringToInt() {
        // given
        String inputValue = "5000";

        // when
        int purchaseAmount = StringUtil.stringToInt(inputValue);

        // then
        Assertions.assertThat(purchaseAmount).isEqualTo(5000);
    }

    @DisplayName("총 수익률 double 값을 문자열 형식으로 변환한다.")
    @Test
    void doubleToString() {
        // given
        double rateOfReturn = 62.5;

        // when
        String printReturnValue = StringUtil.doubleToString(rateOfReturn);

        // then
        Assertions.assertThat(printReturnValue).isEqualTo("총 수익률은 62.5%입니다.");
    }
}
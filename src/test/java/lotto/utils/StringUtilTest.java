package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class StringUtilTest {

    @DisplayName("구입 금액 문자열을 int 값으로 변환한다.")
    @Test
    void stringToInt() {
        // given
        String inputValue = "5000";

        // when
        int purchaseAmount = StringUtil.stringToInt(inputValue);

        // then
        assertThat(purchaseAmount).isEqualTo(5000);
    }

    @DisplayName("정답 로또 번호 문자열을 Integer List 로 변환한다.")
    @Test
    void stringToList() {
        // given
        String inputValue = "1,2,3,4,5,6";

        // when
        List<Integer> answerLotto = StringUtil.StringToList(inputValue);

        // then
        assertThat(answerLotto).contains(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("총 수익률 double 값을 문자열 형식으로 변환한다.")
    @Test
    void doubleToString() {
        // given
        double rateOfReturn = 62.5;

        // when
        String printReturnValue = StringUtil.doubleToString(rateOfReturn);

        // then
        assertThat(printReturnValue).isEqualTo("총 수익률은 62.5%입니다.");
    }
}
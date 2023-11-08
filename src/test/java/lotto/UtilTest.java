package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.global.exception.ErrorMessage;
import lotto.global.util.Util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UtilTest {
    @DisplayName("소수 n번째 자리에서 반올림한다.")
    @Test
    void roundOutFromSecondDecimalPlace() {
        assertThat(Util.round(17.244, 2)).isEqualTo(17.2);
        assertThat(Util.round(17.254, 2)).isEqualTo(17.3);
        assertThat(Util.round(17.254, 3)).isEqualTo(17.25);
    }

    @DisplayName("오름차순으로 리스트 내의 요소를 정렬한다.")
    @Test
    void sortElementInList() {
        assertThat(Util.sortAsc(List.of(2, 7, 4, 9, 1)))
                .isEqualTo(List.of(1, 2, 4, 7, 9));
    }


    @DisplayName("입력을 정수 리스트로 변환하고 숫자가 아닌 것이 있으면 예외가 발생한다.")
    @Test
    void stringToIntegerList() {
        assertThat(Util.parseIntToListOrThrowException("1,2,3,4", ","))
                .isEqualTo(List.of(1, 2, 3, 4));
        assertThat(Util.parseIntToListOrThrowException("12,2,33,4", ","))
                .isEqualTo(List.of(12, 2, 33, 4));
        assertThatThrownBy(() -> Util.parseIntToListOrThrowException("1,2,two", ","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER);
    }
}

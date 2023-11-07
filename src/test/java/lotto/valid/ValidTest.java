package lotto.valid;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;


class ValidTest {


    @DisplayName("구입금액 정상흐름")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000", "100000", "3000"})
    void validPrice(String price) {
        Valid.validPrice(price);
    }

    @DisplayName("구입금액 예외메세지 출력")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "10", "999", "", " ", "1999", "1001"})
    void validPriceException(String price) {
        Assertions.assertThatThrownBy(() -> Valid.validPrice(price)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당청번호 정상흐름")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "45,44,43,42,41,40", "11,10,20,30,40,45", "11,10,20,30,40,1"})
    void validWinNum(String numbers) {
        Valid.validWinNum(numbers);
    }

    @DisplayName("당첨번호 예외메세지 출력")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "0,1,2,3,4,5", "-1,0,3,4,5,6", "1,2,46,4,5", ",,,,,", "", " ", "1,2,3", ",2,,3,","a,b,c,d,e,f"})
    void validWinNumException(String numbers) {
        Assertions.assertThatThrownBy(() -> Valid.validWinNum(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 정상흐름")
    @ParameterizedTest
    @ValueSource(strings = {"1", "45", "44", "2", "22"})
    void validBonusNum(String bonusNum) {
        Valid.validBonusNum(bonusNum);
    }

    @DisplayName("보너스 번호 예외흐름")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "46", "222222222222222", "0", "", " ", " 4 5"})
    void validBonusNumException(String bonusNum) {
        Assertions.assertThatThrownBy(() -> Valid.validBonusNum(bonusNum)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호, 보너스번호 중복 정상흐름")
    @Test
    void distinctCheck() {
        // given
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        String bonusNum = "7";

        // when
        Valid.distinctCheck(list, bonusNum);
    }

    @DisplayName("당첨번호, 보너스번호 중복 예외흐름")
    @Test
    void distinctCheckException() {
        // given
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        String bonusNum = "6";

        // when
        Assertions.assertThatThrownBy(() -> Valid.distinctCheck(list, bonusNum)).isInstanceOf(IllegalArgumentException.class);
    }

}
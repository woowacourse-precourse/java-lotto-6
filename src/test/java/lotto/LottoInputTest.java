package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.LottoInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoInputTest {
    @Test
    @DisplayName("입력받은금액이 로또가격으로 나누어떨어지지않는경우")
    void validateLottoPriceTest() {
        String input = "1500";
        assertThatThrownBy(()->{
            LottoInput.validateLottoPrice(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("입력받은 숫자에 문자가포함된 경우")
    void validateLottoNumberTest(){
        String input = "1000k";
        assertThatThrownBy(()->{
            LottoInput.validateLottoNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호가 6개가 아닌경우의 테스트")
    void validateWinningNumCountTest() {
        String input = "13,42,23,25,27,34,";
        assertThatThrownBy(() -> {
            LottoInput.validateWinningNumCount(input);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("당첨번호의 범위가 1~45를 벗어나는경우")
    void validateWinningNumRangeTest() {
        String input = "13,43,23,25,0,34";
        assertThatThrownBy(() -> {
            LottoInput.validateWinningNumRange(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningtNumRedundantTest() {
        String input = "13,43,22,25,43,34";
        assertThatThrownBy(() -> {
            LottoInput.validateWinningtNumRedundant(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Error]당첨번호는 중복되지않은 숫자 6개입니다.");
    }


    @Test
    void stringToIntList() {
    }
}
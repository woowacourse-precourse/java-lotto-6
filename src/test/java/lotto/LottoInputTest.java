package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoInputTest {

    @Test
    void inputLottoPrice() {
    }

    @Test
    void inputWinningNum() {
    }

    @Test
    void inputBonusNum() {
    }

    @Test
    void validateLottoPrice() {
        String input = "";
        assertThatThrownBy(()->{
            LottoInput.validateLottoPrice(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]값이 천원단위가 아닙니다.");
    }


    @Test
    @DisplayName("당첨번호가 6개가 아닌경우의 테스트")
    void validateWinningNumCountTest() {
        String input = ",13,42,23,25,27,34";
//        ",13,42,23,25,27,34" length = 7
//        "13,42,23,25,27,34," length = 6 검증 필요
        assertThatThrownBy(() -> {
            LottoInput.validateWinningNumCount(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]당첨번호는 6개입니다");
    }

    @Test
    @DisplayName("당첨번호의 범위가 1~45를 벗어나는경우")
    void validateWinningNumRangeTest() {
        String input = "13,43,23,25,0,34";
        assertThatThrownBy(() -> {
            LottoInput.validateWinningNumRange(input, 45);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]당첨번호는 1~45사이의 수 입니다.");
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
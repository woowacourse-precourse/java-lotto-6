package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    // 아래에 추가 테스트 작성 가능

    /*@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new LottoNumberInput().validate(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoNumberInput().validate(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 입력이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottotoByNonNumber() {
        LottoNumberInput lottoNumberInput = new LottoNumberInput();
        assertThatThrownBy(() -> lottoNumberInput.numberInput("a,b,1,d,e,f"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("금액 테스트")
    @Test
    void createMoneyByZeroRemainder() {
        assertThatThrownBy(() -> new LottoNumberInput().moneyInput(14222))
                .isInstanceOf(IllegalArgumentException.class);
    }*/

/*    @DisplayName("중복 테스트")
    @Test
    void dup() {
        assertThatThrownBy(() -> new Lotto().checkDuplicate(List.of(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6자리 테스트")
    @Test
    void six() {
        assertThatThrownBy(() -> new Lotto().checkNumberSize(1,2,3,4,5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("단위 테스트")
    @Test
    void check1000() {
        assertThatThrownBy(() -> new Lotto().check1000("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("양수 테스트")
    @Test
    void plus() {
        assertThatThrownBy(() -> new Lotto().checkValidate("-8000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자인지 테스트")
    @Test
    void isNum() {
        assertThatThrownBy(() -> new Lotto().checkNumInRange("asdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }*/
}
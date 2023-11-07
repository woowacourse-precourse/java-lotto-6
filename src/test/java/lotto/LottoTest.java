package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private LottoController lc = new LottoController();
    private Validator validator = new Validator();
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("구매 금액에 문자를 입력하면 예외가 발생한다.")
    @Test
    void validatorIsNumber(){
        String number = "00notNumber";
        assertThatThrownBy(() -> validator.isNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액에 문자를 입력하면 예외가 발생한다.")
    @Test
    void validatorIsThousands(){
        int number = 24864;
        assertThatThrownBy(() -> validator.isThousands(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자와 컴마외의 문자를 입력하면 예외가 발생한다.")
    @Test
    void validatorIsNumberAndComma(){
        String number = "15,45,28,41.5.7";
        assertThatThrownBy(() -> validator.isNumberAndComma(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 규칙에 벗어난 숫자들을 입력하면 예외가 발생한다.")
    @Test
    void validatorIsLottoNumber(){
        String number = "75,45,28,41,5,16";
        assertThatThrownBy(() -> validator.isLottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
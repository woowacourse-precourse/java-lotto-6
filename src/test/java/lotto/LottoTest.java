package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto().validateLottoNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto().validateLottoNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호에 숫자 외의 입력값이 있으면 예외가 발생한다.")
    @Test
    void createLottoByValidInputNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto().validateLottoNumber("1,2,3,4,5,j"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 번호가 1~45 이외의 값이면 예외가 발생한다ㅏ.")
    @Test
    void createLottoByValidRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto().validateLottoNumber("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력값에 빈값이 존재하면 예외가 발생한다.")
    @Test
    void createLottoByCheckEmptyInput() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto().validateLottoNumber("1,2, ,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}
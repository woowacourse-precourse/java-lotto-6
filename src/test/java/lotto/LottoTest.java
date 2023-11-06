package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.WrongCommasFormatException;
import lotto.exception.WrongTypeFormatException;
import lotto.service.impl.ValidateServiceImpl;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
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

    @DisplayName("로또 번호에 범위가 넘는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinnerNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 44, 45),45))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 범위가 넘는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinnerNumbersByOutOfRangeNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 44, 45),46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 콤마 위치가 잘못되면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void createLottoByWrongCommasFormatOne() {

        ValidateServiceImpl validateService = new ValidateServiceImpl();
        assertThatThrownBy(() -> validateService.checkCorrectWinnerNumbers("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 콤마 위치가 잘못되면 WrongCommasFormatException 예외가 발생한다.")
    @Test
    void createLottoByWrongCommasFormatTwo() {

        ValidateServiceImpl validateService = new ValidateServiceImpl();
        assertThatThrownBy(() -> validateService.checkCorrectWinnerNumbers("1,2,3,4,5,,6"))
                .isInstanceOf(WrongCommasFormatException.class);
    }

    @DisplayName("로또 번호 6개보다 적게 들어오면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void createLottoByLessNumbers() {
        ValidateServiceImpl validateService = new ValidateServiceImpl();
        assertThatThrownBy(() -> validateService.checkCorrectWinnerNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 문자가 들어오면 WrongTypeFormatException 예외가 발생한다.")
    @Test
    void createLottoByWrongChar() {
        ValidateServiceImpl validateService = new ValidateServiceImpl();
        assertThatThrownBy(() -> validateService.checkCorrectWinnerNumbers("1,2,3,4,5,a"))
                .isInstanceOf(WrongTypeFormatException.class);
    }

    @DisplayName("로또 번호에 특수 문자가 들어오면 WrongTypeFormatException 예외가 발생한다.")
    @Test
    void createLottoByWrongSpecialChar() {
        ValidateServiceImpl validateService = new ValidateServiceImpl();
        assertThatThrownBy(() -> validateService.checkCorrectWinnerNumbers("1,2,3,4,5,!"))
                .isInstanceOf(WrongTypeFormatException.class);
    }
}
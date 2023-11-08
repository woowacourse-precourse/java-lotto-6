package lotto;

import lotto.LottoFactory.Lotto;
import lotto.Util.Validate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByLeastSize() {
        assertThatThrownBy(() -> Lotto.createLotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.createLotto(List.of(1, 2, 2, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(" 유효한 로또 번호 목록을 입력하는 경우 예외 발생X")
    void isDuplicateLotto_ValidInput() {
        Validate.isDuplicateLotto(List.of(1, 2, 3, 4, 5, 6)); // 예외 발생하지 않음
    }

    @Test
    @DisplayName("당첨로또 입력시 잘못된 구분자를 사용한 경우 예외 발생")
    void winningLottoInput_InvalidDelimiter() {
        assertThatThrownBy(() -> Validate.WinningLottoInput("1|2 3,4*5a6&"))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
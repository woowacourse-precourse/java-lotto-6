package lotto;

import static lotto.constants.ExceptionMessage.EXCEPTION_DUPLICATED;
import static lotto.constants.ExceptionMessage.EXCEPTION_NEED_BIGGER_NUM;
import static lotto.constants.ExceptionMessage.EXCEPTION_NEED_DIVISIBLE_NUM;
import static lotto.constants.ExceptionMessage.EXCEPTION_NOT_INTEGER;
import static lotto.constants.ExceptionMessage.EXCEPTION_OUT_OF_RANGE;
import static lotto.constants.ExceptionMessage.EXCEPTION_WRONG_LENGTH;
import static lotto.view.Exceptions.validateDivisibleAmount;
import static lotto.view.Exceptions.validateExceedMinimum;
import static lotto.view.Exceptions.validateLottoNum;
import static lotto.view.InputView.changeToInt;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoUITest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_WRONG_LENGTH);
        ;
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_DUPLICATED);
    }

    @DisplayName("구입금액이 1000원보다 작으면 예외가 발생한다.")
    @Test
    void inputPurchaseAmountSmallerThanThousand() {
        assertThatThrownBy(() -> validateExceedMinimum(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_NEED_BIGGER_NUM);
    }

    @DisplayName("구입금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void inputPurchaseAmountUndividedByThousand() {
        assertThatThrownBy(() -> validateDivisibleAmount(2001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_NEED_DIVISIBLE_NUM);
    }

    @DisplayName("로또번호가 최소 번호(1) 보다 작으면 예외가 발생한다.")
    @Test
    void inputSmallerThanMinimumNumber() {
        assertThatThrownBy(() -> validateLottoNum(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_OUT_OF_RANGE);
    }

    @DisplayName("로또번호가 최대 번호(45) 보다 크면 예외가 발생한다.")
    @Test
    void inputBiggerThanMaximumNumber() {
        assertThatThrownBy(() -> validateLottoNum(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_OUT_OF_RANGE);
    }

    @DisplayName("입력된 값이 double값이면 예외가 발생한다.")
    @Test
    void inputDouble() {
        assertThatThrownBy(() -> changeToInt("35.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_NOT_INTEGER);
    }

    @DisplayName("입력된 값이 문자열이면 예외가 발생한다.")
    @Test
    void inputString() {
        assertThatThrownBy(() -> changeToInt("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_NOT_INTEGER);
    }
}

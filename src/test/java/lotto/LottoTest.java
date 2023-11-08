package lotto;

import lotto.domain.Amount;
import lotto.domain.Checker;
import lotto.domain.Result;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.LottoErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액_입력테스트() {
        Amount amount = new Amount(8000);
        assertThat(8000).isEqualTo(amount.getAmount());
        assertThat(8).isEqualTo(amount.getCount());
    }

    @Test
    void 구입금액_예외처리_테스트() {
        assertThatThrownBy(() -> new Amount(8800))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_DIVIDE_ERROR_MESSAGE.getErrorMessage());
        assertThatThrownBy(() -> new Amount(-8000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_NOT_A_NUMBER_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    void 당첨번호_입력테스트() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThat(List.of(1, 2, 3, 4, 5, 6)).isEqualTo(winningNumber.getNumbers());
    }

    @Test
    void 당첨번호_예외처리_테스트() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_LENGTH_ERROR_MESSAGE.getErrorMessage());
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 55, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    void 보너스_번호_입력테스트() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.setBonusNumber(7);
        assertThat(7).isEqualTo(winningNumber.getBonusNumber());
    }

    @Test
    void 보너스_번호_예외처리_테스트() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber(55))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    void 당첨_개수_확인_테스트() {
        WinningNumber winningNumber1 = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        winningNumber1.setBonusNumber(7);
        WinningNumber winningNumber2 = new WinningNumber(List.of(3, 11, 35, 43, 20, 21));
        winningNumber2.setBonusNumber(2);
        Checker case1 = new Checker(new Lotto(List.of(1, 2, 3, 4, 5, 6)), winningNumber1);
        Checker case2 = new Checker(new Lotto(List.of(11, 23, 43, 2, 29, 21)), winningNumber2);

        assertThat(6).isEqualTo(case1.getCount());
        assertThat(false).isEqualTo(case1.isBonus());
        assertThat(3).isEqualTo(case2.getCount());
        assertThat(true).isEqualTo(case2.isBonus());
    }

    @Test
    void 결괏값_확인_테스트() {
        Amount amount = new Amount(8000);
        WinningNumber winningNumber1 = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        winningNumber1.setBonusNumber(7);
        Result result = new Result(List.of(new Checker((new Lotto(List.of(11, 2, 33, 4, 55, 6))), winningNumber1)));
        assertThat(List.of(1, 0, 0, 0, 0)).isEqualTo(result.getResults());
        assertThat(62.5).isEqualTo(result.getEarningRate(amount.getAmount()));
    }
}
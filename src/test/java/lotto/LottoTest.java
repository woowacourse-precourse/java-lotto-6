package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Validator.validatePaymentAmount;
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

    @DisplayName("로또 번호가 1부터 45까지의 수가 아닐 경우 예외처리가 동작하도록 한다.")
    @Test
    void createLottoByOutOfBoundsNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("수익성을 계산하는 코드가 맞는지 검토한다.")
    @Test
    void calculateProfitability() {
        int purchasedLottosSize = 8;
        double profit = 5000;
        double profitability;

        double payment = purchasedLottosSize * 1000;
        profitability =  profit * 100 / payment;

        assertThat(profitability).isEqualTo(62.5);
    }

    @DisplayName("지불 금액이 0인 경우 예외처리가 정상 작동하는지 확인합니다")
    @Test
    void assertPaymentNonZeroValue() {
        assertThatThrownBy(() -> validatePaymentAmount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지불 금액이 음수일 경우 예외처리가 정상 작동하는지 확인합니다.")
    @Test
    void assertPaymentPositiveValue() {
        assertThatThrownBy(() -> validatePaymentAmount(-5000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
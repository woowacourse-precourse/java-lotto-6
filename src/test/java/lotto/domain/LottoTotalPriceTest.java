package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTotalPriceTest {

    @DisplayName("정상적으로 로또 입력 개수를 뽑아오는지 확인")
    @Test
    void createLottoCount() {
        String price = "14000";
        LottoTotalPrice lottoTotalPrice = new LottoTotalPrice(price);

        Assertions.assertThat(lottoTotalPrice.getNumberOfPurchasedLotto()).isEqualTo(14);
    }

    @DisplayName("정상적으로 로또 총 구입 금액을 받아오는지 확인")
    @Test
    void createLottoAmount() {
        String price = "14000";
        LottoTotalPrice lottoTotalPrice = new LottoTotalPrice(price);

        Assertions.assertThat(lottoTotalPrice.getPrice()).isEqualTo(14000);
    }

    @DisplayName("숫자가 아닌 금액을 입력했을 때 예외 발생")
    @Test
    void createStringLottoPrice() {
        assertThatThrownBy(() -> new LottoTotalPrice("abcde"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 미만 금액을 입력했을 때 예외 발생")
    @Test
    void createZeroLottoPrice() {
        assertThatThrownBy(() -> new LottoTotalPrice("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위 금액이 아닌 금액을 입력했을 때 예외 발생")
    @Test
    void createNotThousandLottoPrice() {
        assertThatThrownBy(() -> new LottoTotalPrice("1355"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 char을 함께 입력했을 때 예외 발생")
    @Test
    void createLottoPriceWithChar() {
        assertThatThrownBy(() -> new LottoTotalPrice("1355a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력 - 빈 값을 입력한 경우 예외 발생")
    @Test
    void checkInputIsNotEmpty() {
        assertThatThrownBy(() -> new Lotto(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력 - 띄어쓰기만 입력한 경우 예외 발생")
    @Test
    void checkInputIsSpace() {
        assertThatThrownBy(() -> new Lotto("    "))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
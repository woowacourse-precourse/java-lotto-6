package lottovender;

import lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoVenderTest {

    @DisplayName("구매 금액을 빈칸으로 입력할 시 예외 발생")
    @Test
    void inputBlank() {
        LottoVender lv = new LottoVender();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lv.payPrice(" ");
        });
    }

    @DisplayName("숫자가 아닐경우 예외 처리")
    @Test
    void input_not_a_number() {
        LottoVender lv = new LottoVender();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lv.payPrice("error");
        });
    }

    @DisplayName("숫자가 아닐경우 예외 처리")
    @Test
    void input_can_not_be_divided_by_1000() {
        LottoVender lv = new LottoVender();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lv.payPrice("1004");
        });
    }

    @DisplayName("로또 구입 비용 지불")
    @Test
    void pay_price_for_lotto() {
        LottoVender lv = new LottoVender();
        Assertions.assertTrue(lv.payPrice("15000")==15);
    }

    @Test
    void getLotto() {
        System.out.println("1");
    }
}
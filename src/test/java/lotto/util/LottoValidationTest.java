package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidationTest {

    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외 발생")
    @Test
    void createLottoByOverSize() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        String input = "5500";

        assertThatThrownBy(() -> lottoPurchase.lottoPurchaseCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("구입 금액에 숫자가 아닌 다른 문자가 들어갈 경우 예외 발생")
    @Test
    void createLottoNonNumber() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        String input = "5500l";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoPurchase.lottoPurchaseCount(input);
        });
    }

    @DisplayName("로또 당첨 번호에 숫자가 아닌 다른 문자가 들어갈 경우 예외 발생")
    @Test
    void createLottoWinningNumberOnlyNumber() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        String notNumber = "2,5,8,16,25,o";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoWinningNumber.lottoWinningNumber(notNumber);
        });
    }

}

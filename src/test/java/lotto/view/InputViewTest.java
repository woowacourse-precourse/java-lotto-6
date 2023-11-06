package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.model.BuyPriceValidator;
import lotto.model.WinningNumberValidator;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    void 입력된_로또_구입_금액이_숫자가_아닐_때(){
        //given
        String buyPrice = "천원";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new BuyPriceValidator(buyPrice));
        //then
        assertThat(e.getMessage()).isEqualTo("[ERROR] 로또 구입 금액은 숫자를 입력해야 합니다.");
    }

    @Test
    void 입력된_로또_구입_금액이_1000으로_나누어_떨어지지_않을_때(){
        //given
        String buyPrice = "12500";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new BuyPriceValidator(buyPrice));
        //then
        assertThat(e.getMessage()).isEqualTo("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
    }

    @Test
    void 입력된_당첨_번호에_중복이_있을_때(){
        //given
        String winningNumber = "1,2,3,4,5,5";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new WinningNumberValidator(winningNumber));
        //then
        assertThat(e.getMessage()).isEqualTo("[ERROR] 각각 다른 숫자를 입력해야 합니다.");
    }

    @Test
    void 입력된_당첨_번호가_숫자가_아닌_경우(){
        //given
        String winningNumber = "일이삼사오육";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new WinningNumberValidator(winningNumber));
        //then
        assertThat(e.getMessage()).isEqualTo("[ERROR] 당첨 번호는 숫자를 입력해야 합니다.");
    }

}

package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.xml.validation.Validator;
import lotto.model.BuyPriceValidator;
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

}

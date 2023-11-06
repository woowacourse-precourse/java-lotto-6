package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.enums.ExceptionMessage;
import lotto.model.BonusNumber;
import lotto.model.Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    private Lotto lotto;

    @BeforeEach
    public void init(){
        final String numbers = "1,2,3,4,5,6";
        this.lotto = new Lotto(numbers);
    }

    @Test
    @DisplayName("올바른 보너스 번호가 입력된 경우")
    void 올바른_보너스번호_입력() throws Exception{
        //given
        final String number = "23";

        //when
        BonusNumber bonusNumber = new BonusNumber(number,lotto);

        //then
        assertThat(bonusNumber.getValue()).isEqualTo(Integer.valueOf(number));
    }

    @Test
    @DisplayName("공백과 함께 올바른 보너스 번호가 입력된 경우")
    void 올바른_보너스번호_공백_입력() throws Exception{
        //given
        final String number = "  23    ";

        //when
        BonusNumber bonusNumber = new BonusNumber(number,lotto);

        //then
        assertThat(bonusNumber.getValue()).isEqualTo(Integer.valueOf(number.replaceAll(" ","")));
    }

    @Test
    @DisplayName("1~45사이의 수가 입력되지 않은 경우")
    void 올바르지_않은_범위의_보너스번호_입력() throws Exception{
        //given
        final String number = "46";

        //when, then
        assertThatThrownBy(() -> new BonusNumber(number,lotto)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber(number,lotto)).hasMessage(
                ExceptionMessage.BONUS_NUMBER_IS_NOT_BETWEEN_ONE_AND_FORTYFIVE.getMessage());
    }

    @Test
    @DisplayName("아무런 값도 입력되지 않은 경우")
    void 빈값_입력() throws Exception{
        //given
        final String number = "";

        //when, then
        assertThatThrownBy(() -> new BonusNumber(number,lotto)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber(number,lotto)).hasMessage(
                ExceptionMessage.BONUS_NUMBER_IS_EMPTY.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 입력된 경우")
    void 숫자가_아닌_문자입력() throws Exception{
        //given
        final String number = "a";

        //when, then
        assertThatThrownBy(() -> new BonusNumber(number,lotto)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber(number,lotto)).hasMessage(
                ExceptionMessage.BONUS_NUMBER_IS_NOT_NUMBER.getMessage());
    }
}

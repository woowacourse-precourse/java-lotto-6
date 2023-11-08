package lotto;

import lotto.model.Lotto;
import lotto.validator.ValidateBonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusNumberTest {
    @DisplayName("로또 보너스 번호 입력값 받을 때 값이 비어있으면 예외가 발생한다.")
    @Test
    void validateEmpty(){
        String input="";
        assertThatThrownBy(()-> ValidateBonusNumber.validateBonusNumber(input))
                .hasMessage("[ERROR] 값을 입력해주세요.");
    }
    @DisplayName("로또 보너스 번호 입력값이 숫자가 아닌 값일 때 예외 발생.")
    @Test
    void validateConvertable(){
        String input="a";
        assertThatThrownBy(()->ValidateBonusNumber.validateBonusNumber(input))
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }
    @DisplayName("로또 보너스 번호 입력값이 1~45사이가 아닌 경우 예외 발생.")
    @Test
    void validateNumberRange(){
        String input="46";
        assertThatThrownBy(()->ValidateBonusNumber.validateBonusNumber(input))
                .hasMessage("[ERROR] 숫자의 범위는 1~45 입니다.");
    }
    @DisplayName("로또 보너스 번호가 당첨번호와 중복될 시 예외발생.")
    @Test
    void validateDuplicateBonusNumber(){
        Lotto winningNumber=new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber=1;
        assertThatThrownBy(()->ValidateBonusNumber.validateDuplicateBonusNumber(winningNumber,bonusNumber))
                .hasMessage("[ERROR] 보너스번호는 당첨번호와 중복될 수 없습니다");
    }

}

package lotto;

import lotto.dto.Money;
import lotto.view.InputBonusNumber;
import lotto.view.InputNumber;
import lotto.view.InputUserMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    private InputBonusNumber inputBonusNumber = new InputBonusNumber();
    private InputNumber inputNumber = new InputNumber();
    private InputUserMoney inputUserMoney = new InputUserMoney();

    @DisplayName("입력한 보너스 번호가 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void checkBonusNumberValidate(){
        String input = "1j";

        assertThatThrownBy(() -> inputBonusNumber.checkValidateRange(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력한 보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void checkBonusNumberRange(){
        String input = "100";

        assertThatThrownBy(() -> inputBonusNumber.checkValidateRange(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력한 로또 번호가 올바른 구분자로 구분이 안되어 있으면 예외가 발생한다.")
    @Test
    void checkInputNumberValidate(){
        String input = "1/2/3/4/5/6";

        assertThatThrownBy(() -> inputNumber.checkValidate(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력한 구매 금액이 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void checkInputUserMoneyValidate(){
        String input = "1000j";
        assertThatThrownBy(() -> inputUserMoney.checkValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void checkInputUserMoneyDigit(){
        int input = 1121212;
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 양수가 아닌 경우 예외가 발생한다.")
    @Test
    void checkInputUserMoneyPositive(){
        int input = -10;
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

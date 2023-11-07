package lotto.view;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @DisplayName("구입 금액이 비어있으면 예외가 발생한다.")
    @Test
    void testValidateAmountHasText(){
        String input = "";
        assertThatThrownBy(()-> Validator.checkAmount(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액이 비어있습니다.");
    }

    @DisplayName("구입 금액이 입력이 정수가 아니면 예외가 발생한다.")
    @Test
    void testValidateAmountIsInteger(){
        String input = "aa";
        assertThatThrownBy(()-> Validator.checkAmount(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 정수가 아닙니다.");
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생 한다.")
    @Test
    void testValidateAmountIsDivided(){
        String input = "1100";
        assertThatThrownBy(()-> Validator.checkAmount(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액이 1000으로 나누어 떨어지지 않습니다.");
    }

    @DisplayName("구입 금액이 최소 구입 금액 보다 작으면 예외가 발생한다.")
    @Test
    void testValidateAmountMinimum(){
        String input = "990";
        assertThatThrownBy(()-> Validator.checkAmount(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최소 구입 금액은 1000원 입니다.");
    }

    @DisplayName("입력받은 로또 번호가 비어있으면 예외가 발생한다.")
    @Test
    void testValidateNumberHasText(){
        String[] input = {"1","2","3","4","5",""};
        assertThatThrownBy(()-> Validator.checkNumbers(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액이 비어있습니다.");
    }

    @DisplayName("입력받은 로또 번호 갯수가 6개가 아니면 예외가 발생한다.")
    @Test
    void testValidateNumberCount(){
        String[] input = {"1","2","3","4","5"};
        assertThatThrownBy(()-> Validator.checkNumbers(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호 갯수가 6개가 아닙니다.");
    }

    @DisplayName("입력받은 로또 번호의 범위가 1부터 45가 아닐 시 예외가 발생한다. (45보다 큰 경우)")
    @Test
    void testValidateRange1(){
        String[] input = {"1","2","3","48","5","6"};
        assertThatThrownBy(()-> Validator.checkNumbers(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호의 범위는 1부터 45 까지 입니다.");
    }

    @DisplayName("입력받은 로또 번호의 범위가 1부터 45가 아닐 시 예외가 발생한다. (1보다 작은 경우)")
    @Test
    void testValidateRange2(){
        String[] input = {"0","2","3","42","5","6"};
        assertThatThrownBy(()-> Validator.checkNumbers(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호의 범위는 1부터 45 까지 입니다.");
    }

    @DisplayName("입력받은 로또 번호가 정수가 아니라면 예외가 발생한다.")
    @Test
    void testValidateInteger(){
        String[] input = {"1","2","3","4","5","a"};
        assertThatThrownBy(()-> Validator.checkNumbers(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 정수가 아닙니다.");
    }


}

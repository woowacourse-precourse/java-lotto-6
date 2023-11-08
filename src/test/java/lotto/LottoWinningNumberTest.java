package lotto;

import lotto.validator.ValidateWinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumberTest {
    @DisplayName("당첨번호 입력값을 받을 떄 값이 비어있으면 예외 발생.")
    @Test
    void validateEmpty(){
        String input="";
        assertThatThrownBy(()-> ValidateWinningNumber.validateWinningNumber(input))
                .hasMessage("[ERROR] 숫자를 입력헤주세요.");
    }

    @DisplayName("당첨번호 입력값을 받을 때 입력값이 숫자가 아니면 예외발생.")
    @Test
    void validateNumerical(){
        String input="a,1,2,3,4,5";
        assertThatThrownBy(()->ValidateWinningNumber.validateWinningNumber(input))
                .hasMessage("[ERROR] 입력값으로 올바른 숫자를 입력하십시오.");
    }

    @DisplayName("당첨번호 입력값을 받을 떄 입력값의 범위가 1~45가 아닐 때 예외발생.")
    @Test
    void validateNumberRange(){
        String input="1,2,3,4,5,50";
        assertThatThrownBy(()->ValidateWinningNumber.validateWinningNumber(input))
                .hasMessage("[ERROR] 숫자의 범위는 1~45 입니다.");
    }

    @DisplayName("당첨번호 입력값을 받을 때 입력값이 6자리 이상일 때 예외발생.")
    @Test
    void validateSize(){
        String input="1,2,3,4,5,6,7";
        assertThatThrownBy(()->ValidateWinningNumber.validateWinningNumber(input))
                .hasMessage("[ERROR] 당첨번호는 6자리 입력 가능합니다.");
    }

    @DisplayName("당첨번호 입력값을 받을 떄 입력값에 중복이 있을경우 예외발생.")
    @Test
    void validateDuplication(){
        String input="1,2,2,3,4,6";
        assertThatThrownBy(()->ValidateWinningNumber.validateWinningNumber(input))
                .hasMessage("[ERROR] 증복된 숫자는 입력할 수 없습니다.");
    }
}

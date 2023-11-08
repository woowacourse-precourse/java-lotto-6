package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static lotto.CheckNumber.*;

public class CheckNumberTest {
    @DisplayName("구매 금액을 1000원 이하, 1000로 나누어지지 않게 입력하면 예외 발생")
    @Test
    void checkPerchaseMoneyTest(){
        Assertions.assertThatThrownBy(() -> checkPurchaseMoney(800)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> checkPurchaseMoney(1001)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자를 입력하지 않은 경우 예외 발생")
    @Test
    void checkTextInputText(){
        Assertions.assertThatThrownBy(() -> checkTextInput("400$")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호를 6개 입력하지 않거나 쉼표 사이 숫자가 없거나 45보다 큰 수를 입력한 경우 예외 발생")
    @Test
    void checkPrizeNumber1Test(){
        Assertions.assertThatThrownBy(() -> checkPrizeNumber1("1,2,3,4,5,6,7")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> checkPrizeNumber1("1,2,3,,5,6")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> checkPrizeNumber1("46,47,48,49,50,51")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 중 동일한 번호를 입력한 경우 예외 발생")
    @Test
    void checkPrizeNumber2Test(){
        Assertions.assertThatThrownBy(() -> checkPrizeNumber2("1,2,3,4,5,5")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 입력하지 않거나 45보다 큰 숫자를 입력하거나 당첨 번호에 존재하는 번호일 경우 예외 발생")
    @Test
    void checkBonusNumberTest(){
        ArrayList<Integer> prizeNumberArray = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Assertions.assertThatThrownBy(() -> checkBonusNumber("", prizeNumberArray)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> checkBonusNumber("46", prizeNumberArray)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> checkBonusNumber("1", prizeNumberArray)).isInstanceOf(IllegalArgumentException.class);
    }
}

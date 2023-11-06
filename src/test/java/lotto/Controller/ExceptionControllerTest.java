package lotto.Controller;

import lotto.model.BonusNumber;
import lotto.model.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.ExceptionController.*;

public class ExceptionControllerTest {
    @DisplayName("가격 예외 테스트")
    @Test
    void checkPriceExceptionTest() {
        //Assertions.assertThatThrownBy(() -> checkPriceException("a")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> checkPriceException(999)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> checkPriceException(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 가격 예외 테스트")
    @Test
    void checkRightPriceExceptionTest() {
        Price price = new Price(1000);
        Price resultPrice = checkPriceException(1000);

        Assertions.assertThat(price.getPrice()).isEqualTo(resultPrice.getPrice());
    }

    @DisplayName("잘못된 보너스 숫자 예외 테스트")
    @Test
    void checkBonusNumberExceptionTest() {
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        int wrongBonusNumber1 = 1;
        //String wrongBonusNumber2 = "a";
        int wrongBonusNumber3 = 0;
        int wrongBonusNumber4 = 46;

        Assertions.assertThatThrownBy(() -> checkBonusNumberException(numbers, wrongBonusNumber1)).isInstanceOf(IllegalArgumentException.class);
        //Assertions.assertThatThrownBy(() -> checkBonusNumberException(numbers, wrongBonusNumber2)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> checkBonusNumberException(numbers, wrongBonusNumber3)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> checkBonusNumberException(numbers, wrongBonusNumber4)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 보너스 숫자 테스트")
    @Test
    void checkRightBonusNumberExceptionTest() {
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        int rightBonusNumber = 7;

        BonusNumber resultBonus = checkBonusNumberException(numbers, rightBonusNumber);
        BonusNumber bonusNumber = new BonusNumber(7);

        Assertions.assertThat(resultBonus.getBonusNumber()).isEqualTo(bonusNumber.getBonusNumber());
    }

    @DisplayName("잘못된 당첨 숫자 예외 테스트")
    @Test
    void checkWinningNumberExceptionTest() {
        Assertions.assertThatThrownBy(() ->  checkWinningNumberException(List.of(1,2,3,4,5,46))).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->  checkWinningNumberException(List.of(1,2,3,4,5,0))).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->  checkWinningNumberException(List.of(1,2,3,4,5))).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->  checkWinningNumberException(List.of(1,2,3,4,5,5))).isInstanceOf(IllegalArgumentException.class);
    }

}

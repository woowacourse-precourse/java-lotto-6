package lotto.Exception;

import lotto.model.BonusNumber;
import lotto.model.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.ExceptionController.*;
import static lotto.exception.PriceException.checkPriceException;

public class ExceptionControllerTest {




    @DisplayName("잘못된 당첨 숫자 예외 테스트")
    @Test
    void checkWinningNumberExceptionTest() {
        Assertions.assertThatThrownBy(() ->  checkWinningNumberException(List.of(1,2,3,4,5,46))).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->  checkWinningNumberException(List.of(1,2,3,4,5,0))).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->  checkWinningNumberException(List.of(1,2,3,4,5))).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->  checkWinningNumberException(List.of(1,2,3,4,5,5))).isInstanceOf(IllegalArgumentException.class);
    }

}

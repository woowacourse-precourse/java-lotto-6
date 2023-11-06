package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CensorTest {

    @DisplayName("로또 번호가 6개를 초과 한다면, 예외가 발생 한다.")
    @Test
    void validateLottoMethodSizeOverTest() {
        List<Integer> invalidLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThrows(IllegalArgumentException.class, () -> Censor.validateLotto(invalidLotto));
    }

    @DisplayName("로또 번호가 6개 미만 이라면, 예외가 발생 한다.")
    @Test
    void validateLottoMethodSizeLessTest() {
        List<Integer> invalidLotto = List.of(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> Censor.validateLotto(invalidLotto));
    }

    @DisplayName("로또 구입 비용이 로또 가격과 나누어 떨어지지 않는다면, 예외가 발생한다.")
    @Test
    void validatePurchaseUnitMethodTest() {
        int invalidMoney = 1001;
        assertThrows(IllegalArgumentException.class,
                () -> Censor.validatePurchaseUnit(invalidMoney));
    }

    @DisplayName("입력 값이 공백이라면, 예외가 발생한다.")
    @Test
    void validatePurchaseAmountMethodSpaceTest() {
        String inputNull = null;
        String inputEnter = "";
        String inputSpace = " ";

        assertThrows(IllegalArgumentException.class,
                () -> Censor.validatePurchaseAmount(inputNull));
        assertThrows(IllegalArgumentException.class,
                () -> Censor.validatePurchaseAmount(inputEnter));
        assertThrows(IllegalArgumentException.class,
                () -> Censor.validatePurchaseAmount(inputSpace));
    }

    @DisplayName("입력 값이 정수가 아니라면, 예외가 발생한다.")
    @Test
    void validatePurchaseAmountMethodNumericTest() {
        String input = "팔천원";

        assertThrows(IllegalArgumentException.class,
                () -> Censor.validatePurchaseAmount(input));
    }

}

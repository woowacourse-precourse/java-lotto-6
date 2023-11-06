package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

    @DisplayName("당첨 번호 입력에 쉼표(,)만 입력할 경우, 예외가 발생한다.")
    @Test
    void validateOnlyCommaInputTest() {
        String input = ",";

        assertThrows(IllegalArgumentException.class,
                () -> Censor.validateWinningNumbersInput(input));
    }

    @DisplayName("당첨 번호 입력의 시작과 끝에 쉼표(,)를 입력할 경우, 예외가 발생한다.")
    @Test
    void validateStartOrEndWithCommaInputTest() {
        String inputStartWith = ",1,2,3,4,5,6";
        String inputEndWith = "1,2,3,4,5,6,";

        assertThrows(IllegalArgumentException.class,
                () -> Censor.validateWinningNumbersInput(inputStartWith));
        assertThrows(IllegalArgumentException.class,
                () -> Censor.validateWinningNumbersInput(inputEndWith));
    }

    @DisplayName("당첨 번호 입력에 정수가 아닌 값을 입력할 경우, 예외가 발생한다.")
    @Test
    void validateWinningNumbersInputMethodNemericTest() {
        String input = "일,이,삼,사,오,육";

        assertThrows(IllegalArgumentException.class,
                () -> Censor.validateWinningNumbersInput(input));
    }

    @DisplayName("당첨 번호 입력에 중복된 숫자를 입력할 경우, 예외가 발생한다.")
    @Test
    void validateAnnouncementNumberMethodUniqueValueTest() {
        List<Integer> invalidLotto = List.of(1, 1, 3, 4, 5);

        assertThrows(IllegalArgumentException.class,
                () -> Censor.validateAnnouncementNumber(invalidLotto));
    }

    @DisplayName("당첨 번호 입력에 1 ~ 45 범위가 아닌 값을 입력하는 경우, 예외가 발생한다.")
    @Test
    void validateAnnouncementNumberMethodRangeOverTest() {
        List<Integer> invalidLotto = List.of(1, 2, 3, 4, 55);

        assertThrows(IllegalArgumentException.class,
                () -> Censor.validateAnnouncementNumber(invalidLotto));
    }


    @DisplayName("당첨 번호 입력에 공백을 입력할 경우, 예외가 발생한다.")
    @Test
    void validateWinningNumbersInputMethodCommonTest() {
        String inputNull = null;
        String inputEnter = "";
        String inputSpace = " ";

        assertThrows(IllegalArgumentException.class,
                () -> Censor.validateWinningNumbersInput(inputNull));
        assertThrows(IllegalArgumentException.class,
                () -> Censor.validateWinningNumbersInput(inputEnter));
        assertThrows(IllegalArgumentException.class,
                () -> Censor.validateWinningNumbersInput(inputSpace));
    }
    
}

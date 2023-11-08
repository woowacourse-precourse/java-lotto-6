package lotto.util;

import static lotto.util.ModelCensor.validateAnnouncementNumber;
import static lotto.util.ModelCensor.validateLotto;
import static lotto.util.ModelCensor.validatePurchaseUnit;
import static lotto.util.ViewCensor.containUniqueValue;
import static lotto.util.ViewCensor.validatePurchase;
import static lotto.util.ViewCensor.validateWinningNumber;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CensorTest {

    @DisplayName("로또 번호가 6개를 초과 한다면, 예외가 발생 한다.")
    @Test
    void validateLottoMethodSizeOverTest() {
        List<Integer> invalidLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThrows(IllegalArgumentException.class, () -> validateLotto(invalidLotto));
    }

    @DisplayName("로또 번호가 6개 미만 이라면, 예외가 발생 한다.")
    @Test
    void validateLottoMethodSizeLessTest() {
        List<Integer> invalidLotto = List.of(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> validateLotto(invalidLotto));
    }

    @DisplayName("로또 구입 비용이 로또 가격과 나누어 떨어지지 않는다면, 예외가 발생한다.")
    @Test
    void validatePurchaseUnitMethodTest() {
        int invalidMoney = 1001;
        assertThrows(IllegalArgumentException.class,
                () -> validatePurchaseUnit(invalidMoney));
    }

    @DisplayName("입력 값이 공백이라면, 예외가 발생한다.")
    @Test
    void validatePurchaseAmountMethodSpaceTest() {
        String inputEnter = "";
        String inputSpace = " ";

        assertThrows(IllegalArgumentException.class,
                () -> validatePurchase(null));
        assertThrows(IllegalArgumentException.class,
                () -> validatePurchase(inputEnter));
        assertThrows(IllegalArgumentException.class,
                () -> validatePurchase(inputSpace));
    }

    @DisplayName("입력 값이 정수가 아니라면, 예외가 발생한다.")
    @Test
    void validatePurchaseAmountMethodNumericTest() {
        String input = "팔천원";

        assertThrows(IllegalArgumentException.class,
                () -> validatePurchase(input));
    }

    @DisplayName("당첨 번호 입력에 쉼표(,)만 입력할 경우, 예외가 발생한다.")
    @Test
    void validateOnlyCommaInputTest() {
        String input = ",";

        assertThrows(IllegalArgumentException.class,
                () -> validateWinningNumber(input));
    }

    @DisplayName("당첨 번호 입력의 시작과 끝에 쉼표(,)를 입력할 경우, 예외가 발생한다.")
    @Test
    void validateStartOrEndWithCommaInputTest() {
        String inputStartWith = ",1,2,3,4,5,6";
        String inputEndWith = "1,2,3,4,5,6,";

        assertThrows(IllegalArgumentException.class,
                () -> validateWinningNumber(inputStartWith));
        assertThrows(IllegalArgumentException.class,
                () -> validateWinningNumber(inputEndWith));
    }

    @DisplayName("당첨 번호 입력에 정수가 아닌 값을 입력할 경우, 예외가 발생한다.")
    @Test
    void validateWinningNumbersInputMethodNemericTest() {
        String input = "일,이,삼,사,오,육";

        assertThrows(IllegalArgumentException.class,
                () -> validateWinningNumber(input));
    }

    @DisplayName("당첨 번호 입력에 중복된 숫자를 입력할 경우, 예외가 발생한다.")
    @Test
    void validateAnnouncementNumberMethodUniqueValueTest() {
        List<Integer> invalidLotto = List.of(1, 1, 3, 4, 5);

        assertThrows(IllegalArgumentException.class,
                () -> validateAnnouncementNumber(invalidLotto));
    }

    @DisplayName("당첨 번호 입력에 1 ~ 45 범위가 아닌 값을 입력하는 경우, 예외가 발생한다.")
    @Test
    void validateAnnouncementNumberMethodRangeOverTest() {
        List<Integer> invalidLotto = List.of(1, 2, 3, 4, 55);

        assertThrows(IllegalArgumentException.class,
                () -> validateAnnouncementNumber(invalidLotto));
    }


    @DisplayName("당첨 번호 입력에 공백을 입력할 경우, 예외가 발생한다.")
    @Test
    void validateWinningNumbersInputMethodCommonTest() {
        String inputNull = null;
        String inputEnter = "";
        String inputSpace = " ";

        assertThrows(IllegalArgumentException.class,
                () -> validateWinningNumber(inputNull));
        assertThrows(IllegalArgumentException.class,
                () -> validateWinningNumber(inputEnter));
        assertThrows(IllegalArgumentException.class,
                () -> validateWinningNumber(inputSpace));
    }

    @DisplayName("보너스 번호가 당첨 번호에 중복된 번호라면, 예외가 발생한다.")
    @Test
    void containUniqueValueMethodUniqueTest() {
        String input = "1";
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThrows(IllegalArgumentException.class,
                () -> containUniqueValue(input, winningLotto));
    }

}

package lotto.unitTest;

import lotto.constant.Error;
import lotto.data.WinningNumbers;
import lotto.input.InputValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000","8000","12000"})
    @DisplayName("로또 구입 금액은 1000으로 나누어 떨어져야 한다")
    public void testCheckLottoPurchaseAmountValid(String validInput) {
        try {
            InputValidator.checkPurchaseAmount(validInput);
        } catch (IllegalArgumentException e) {
            fail("예외가 발생해서는 안됩니다.");
        }
    }

    @ParameterizedTest
    @ValueSource(strings={"abc",""," ","hEl22k","안녕!","-1000"})
    @DisplayName("로또 구입 금액을 입력받을때 숫자가 아니면 예외가 발생한다.")
    public void testCheckLottoPurchaseAmountInvalidNotNumber(String invalidInput) {

        try {
            InputValidator.checkPurchaseAmount(invalidInput);
            fail("IllegalArgumentException이 발생해야 합니다.");
        } catch (IllegalArgumentException e) {
            assertEquals(Error.NOT_NUMBER,e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"100","900","1001","100000002","1000100","1234456"})
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    public void testCheckLottoPurchaseAmountInvalidNotDividedBy1000(String invalidInput) {
        try {
            InputValidator.checkPurchaseAmount(invalidInput);
            fail("IllegalArgumentException이 발생해야 합니다.");
        } catch (IllegalArgumentException e) {
            assertEquals(Error.DO_NOT_DIVIDED_BY_1000, e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5","1,1,1,1,1,1","1,23,4,5,5,5"})
    @DisplayName("로또 당첨 번호에 중복된 숫자를 입력하면 예외가 발생한다.")
    public void testWinningNumberDuplicateInput(String invailidInput){
        try {
            InputValidator.checkWinningNumbers(invailidInput);
            fail("IllegalArgumentException이 발생해야 합니다.");
        }catch (IllegalArgumentException e){
            assertEquals(Error.PLEASE_ENTER_A_UNDUPLICATED_NUMBER_OF_6,e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","1,2,3","1,2,3,4,5,6,7","1,2,3,4,5,"})
    @DisplayName("로또 당첨 번호에 6개의 수를 입력 안하면 예외가 발생한다.")
    public void testWinningNumberCountInput(String invailidInput){
        InputValidator validator = new InputValidator();

        try {
            InputValidator.checkWinningNumbers(invailidInput);
            fail("IllegalArgumentException이 발생해야 합니다.");
        }catch (IllegalArgumentException e){
            assertEquals(Error.PLEASE_ENTER_A_UNDUPLICATED_NUMBER_OF_6,e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46","일,2,3,4,5,6","one,two,three,four,five,six","1,2,,4,5,6"})
    @DisplayName("로또 당첨 번호에 1~45의 정수를 입력 안하면 예외가 발생한다.")
    public void testWinningNumberInput(String invailidInput){

        try {
            InputValidator.checkWinningNumbers(invailidInput);
            fail("IllegalArgumentException이 발생해야 합니다.");
        }catch (IllegalArgumentException e){
            assertEquals(Error.PLEASE_ENTER_ONLY_NUMBERS_FROM_1_TO_45,e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"A","0","46","1000","하나",""," "})
    @DisplayName("보너스 번호에 1~45의 정수를 입력 안하면 예외가 발생한다.")
    public void testBonusNumberinput(String invailidInput){


        WinningNumbers winningNumbers = new WinningNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        try {
            InputValidator.checkBonusNumber(invailidInput,winningNumbers);

            fail("IllegalArgumentException이 발생해야 합니다.");
        }catch (IllegalArgumentException e){
            assertEquals(Error.PLEASE_ENTER_ONLY_NUMBERS_FROM_1_TO_45,e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4","5","6"})
    @DisplayName("보너스 번호에 1~45의 정수를 입력 안하면 예외가 발생한다.")
    public void testBonusNumberinputWithWinningNumber(String invailidInput){
        WinningNumbers winningNumbers = new WinningNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        try {
            InputValidator.checkBonusNumber(invailidInput,winningNumbers);
            fail("IllegalArgumentException이 발생해야 합니다.");
        }catch (IllegalArgumentException e){
            assertEquals(Error.ALREADY_EXISTING_WINNING_NUMBER,e.getMessage());
        }
    }


}

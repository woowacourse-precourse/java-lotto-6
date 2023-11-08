package lotto.util;

import lotto.exception.NotValidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.GameExceptionMessage.*;
import static lotto.utility.TestConstant.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class InputValueCheckerTest {
    private InputValueChecker inputValueChecker;

    @BeforeEach
    public void initTest() {
        inputValueChecker = new InputValueChecker();
    }

    @Nested
    @DisplayName("사용자 로또 구매 금액의 유효성을 판단한다.")
    public class checkCostValidationTest {
        private final String cost = String.valueOf(INIT_COST.getConstant());
        private final String errorFormat = "test";
        private final String errorCost = String.valueOf(CONSTANT_ONE.getConstant());

        @Test
        @DisplayName("숫자를 입력하지 않는 경우, 오류를 반환한다.")
        public void throwExceptionByInvalidFormat() {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkCostValidation(errorFormat))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(INPUT_VALUE_IS_NOT_NUMBER.getMessage());
        }

        @Test
        @DisplayName("1000 단위의 금액을 입력하지 않는 경우, 오류를 반환한다.")
        public void throwExceptionByInvalidCost() {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkCostValidation(errorCost))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(INPUT_VALUE_NOT_VALID_FORMAT.getMessage());
        }

        @Test
        @DisplayName("유효성 검사에 통과한다.")
        public void successCheckCostValidation() {
            // when - then
            assertDoesNotThrow(() -> inputValueChecker.checkCostValidation(cost));
        }
    }

    @Nested
    @DisplayName("사용자가 입력하는 당첨 번호의 유효성을 판단한다.")
    public class checkWinnerNumberValidationTest {
        private final List<String> errorByLength = List.of("1", "2", "3");
        private final List<String> errorByDup = List.of("1", "2", "3", "3", "4", "5");
        private final List<String> errorByFormat = List.of("1", "2", "3", "4", "5", "hello");
        private final List<String> errorByRange = List.of("77", "2", "3", "4", "5", "6");
        private final List<String> winnerNumber = List.of("1", "2", "3", "4", "5", "6");


        @Test
        @DisplayName("입력한 당첨 번호의 길이가 유효하지 않을 경우, 오류를 반환한다.")
        public void throwExceptionByInvalidLength() {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkWinnerNumberValidation(errorByLength))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(INPUT_VALUE_NOT_VALID_LENGTH.getMessage());
        }

        @Test
        @DisplayName("입력한 당첨 번호에 중복되는 번호가 존재하는 경우, 오류를 반환한다.")
        public void throwExceptionByDuplicatedNumber() {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkWinnerNumberValidation(errorByDup))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(INPUT_VALUE_MUST_DISTINCT.getMessage());
        }

        @Test
        @DisplayName("숫자가 아닌 다른 값을 입력하는 경우, 오류를 반환한다.")
        public void throwExceptionByInvalidNumber() {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkWinnerNumberValidation(errorByFormat))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(INPUT_VALUE_IS_NOT_NUMBER.getMessage());
        }

        @Test
        @DisplayName("로또 번호의 범위를 벗어난 숫자인 경우, 오류를 반환한다.")
        public void throwExceptionByInvalidRange() {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkWinnerNumberValidation(errorByRange))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(INPUT_VALUE_NOT_VALID_RANGE.getMessage());
        }

        @Test
        @DisplayName("유효성 검사에 통과한다.")
        public void successCheckWinnerNumberValidation() {
            // when - then
            assertDoesNotThrow(() -> inputValueChecker.checkWinnerNumberValidation(winnerNumber));
        }
    }

    @Nested
    @DisplayName("사용자가 입력하는 보너스 번호의 유효성을 판단한다.")
    public class checkBonusNumberValidationTest {
        private final List<Integer> winnerNumber = List.of(1,2,3,4,5,6);
        private final String bonusNumber = "7";
        private final String errorByDup = "6";

        @Test
        @DisplayName("유효하지 않은 보너스 번호를 입력하는 경우, 오류를 반환한다.")
        public void throwExceptionByInvalidBonusNumber() {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkBonusNumberValidation(errorByDup, winnerNumber))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(INPUT_VALUE_MUST_DISTINCT.getMessage());
        }

        @Test
        @DisplayName("유효성 검사에 통과한다.")
        public void successCheckBonusNumberValidation() {
            // when - then
            assertDoesNotThrow(() -> inputValueChecker.checkBonusNumberValidation(bonusNumber, winnerNumber));
        }
    }

    @Nested
    @DisplayName("사용자가 입력하는 번호의 유효성을 판단한다.")
    public class checkLottoNumberValidationTest {
        private final String errorByFormat = "test";
        private final String errorByRange = "99";
        private final String bonusNumber = "9";

        @Test
        @DisplayName("로또 숫자의 범위를 벗어나는 경우, 오류를 반환한다.")
        public void throwExceptionByFormat() {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkLottoNumberValidation(errorByFormat))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(INPUT_VALUE_IS_NOT_NUMBER.getMessage());
        }

        @Test
        @DisplayName("로또 숫자의 범위를 벗어나는 경우, 오류를 반환한다.")
        public void throwExceptionByRange() {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkLottoNumberValidation(errorByRange))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(INPUT_VALUE_NOT_VALID_RANGE.getMessage());
        }

        @Test
        @DisplayName("유효성 검사에 통과한다.")
        public void successCheckLottoNumberValidation() {
            // when - then
            assertDoesNotThrow(() -> inputValueChecker.checkLottoNumberValidation(bonusNumber));
        }
    }
}

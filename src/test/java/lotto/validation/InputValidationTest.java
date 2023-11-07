package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputValidationTest {

    InputValidation inputValidation = new InputValidation();

    @Nested
    class 당첨번호_입력_예외_테스트 {

        public List<String> winningNumbers;

        @BeforeEach
        void 당첨번호_설정() {
            winningNumbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        }


        @Test
        void 당첨번호_중복_예외_확인() {
            winningNumbers.add("5");
            assertThatThrownBy(() -> inputValidation.validateWinningNumbersInput(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 중복되지 않는 6개의 숫자여야 합니다.");
        }

        @Test
        void 당첨번호_빈_입력_예외_확인() {
            List<String> tempWinningNumbers = new ArrayList<>();
            assertThatThrownBy(
                () -> inputValidation.validateWinningNumbersInput(tempWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 값을 입력하세요.");
        }

        @Test
        void 당첨번호_문자_입력_예외_확인() {
            winningNumbers.add("abc");
            assertThatThrownBy(() -> inputValidation.validateWinningNumbersInput(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 정수여야 합니다.");
        }

        @Test
        void 당첨번호_숫자_범위_초과_예외_확인() {
            winningNumbers.add("50");
            assertThatThrownBy(() -> inputValidation.validateWinningNumbersInput(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 1에서 45 사이의 정수여야 합니다.");
        }

        @Test
        void 당첨번호_숫자_범위_미만_예외_확인() {
            winningNumbers.add("0");
            assertThatThrownBy(() -> inputValidation.validateWinningNumbersInput(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 1에서 45 사이의 정수여야 합니다.");
        }

        @Test
        void 당첨번호_개수_초과_예외_확인() {
            winningNumbers.add("6");
            winningNumbers.add("7");
            assertThatThrownBy(() -> inputValidation.validateWinningNumbersInput(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 6개의 정수여야 합니다.");
        }

        @Test
        void 당첨번호_개수_미만_예외_확인() {
            assertThatThrownBy(() -> inputValidation.validateWinningNumbersInput(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 6개의 정수여야 합니다.");
        }
    }

    @Nested
    class 구입금액_입력_예외_테스트 {

        public String purchaseAmount;

        @Test
        void 구매금액_1000배수_예외_확인() {
            purchaseAmount = "12500";
            assertThatThrownBy(() -> inputValidation.validatePurchaseAmountInput(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }

        @Test
        void 구매금액_빈_입력_예외_확인() {
            purchaseAmount = "";
            assertThatThrownBy(() -> inputValidation.validatePurchaseAmountInput(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 값을 입력하세요.");
        }

        @Test
        void 구매금액_문자_입력_예외_확인() {
            purchaseAmount = "abc";
            assertThatThrownBy(() -> inputValidation.validatePurchaseAmountInput(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 정수여야 합니다.");
        }
    }

//    @Nested
//    class 보너스번호_입력_예외_테스트 {
//
//        public String bonusNumber;
//        public List<String> lottoNumbers;
//
//        @BeforeEach
//        void 로또_설정() {
//            lottoNumbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
//        }
//
//        @Test
//        void 보너스번호_빈_입력_예외_확인() {
//            bonusNumber = "";
//            assertThatThrownBy(
//                () -> inputValidation.validateBonusNumberInput(lottoNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("값을 입력하세요.");
//        }
//
//        @Test
//        void 보너스번호_문자_입력_예외_확인() {
//            bonusNumber = "abc";
//            assertThatThrownBy(
//                () -> inputValidation.validateBonusNumberInput(lottoNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("입력값은 정수여야 합니다.");
//        }
//
//        @Test
//        void 보너스번호_숫자_범위_초과_예외_확인() {
//            bonusNumber = "50";
//            assertThatThrownBy(
//                () -> inputValidation.validateBonusNumberInput(lottoNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("입력값은 1에서 45 사이의 정수여야 합니다.");
//        }
//
//        @Test
//        void 보너스번호_숫자_범위_미만_예외_확인() {
//            bonusNumber = "0";
//            assertThatThrownBy(
//                () -> inputValidation.validateBonusNumberInput(lottoNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("입력값은 1에서 45 사이의 정수여야 합니다.");
//        }
//
//        @Test
//        void 보너스번호_당첨번호_중복_예외_확인() {
//            bonusNumber = "5";
//            assertThatThrownBy(
//                () -> inputValidation.validateBonusNumberInput(lottoNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("보너스 숫자는 선택한 로또 번호와 중복될 수 없습니다.");
//        }

}
package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.Validator;
import lotto.validator.WinningLottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoSettingServiceTest {
    static class TestValidator implements Validator<String> {
        @Override
        public String validate(String input) {
            if (input.equals("VALID")) {
                return "PASS!";
            }
            throw new IllegalArgumentException("INPUT_NOT_VALID");
        }
    }

    @Nested
    @DisplayName("입력값 검증 테스트")
    class validate {
        @DisplayName("올바르지 않은 입력값 입력시 비어있는 Optional 반환")
        @Test
        void success_InvalidInput() {
            // give
            LottoSettingService lottoSettingService = new LottoSettingService();
            TestValidator validator = new TestValidator();
            Supplier<String> inputSupplier = () -> "INVALID";
            Consumer<String> errorMessage = e -> {};

            // when
            Optional<String> optional = lottoSettingService.validateInput(validator, inputSupplier, errorMessage);
            // then
            assertThat(optional).isEmpty();
        }

        @DisplayName("올바른 입력값 입력시 입력값을 담은 Optional 반환")
        @Test
        void success_ValidInput() {
            // give
            LottoSettingService lottoSettingService = new LottoSettingService();
            TestValidator validator = new TestValidator();
            Supplier<String> inputSupplier = () -> "VALID";
            Consumer<String> errorMessage = e -> {};

            // when
            Optional<String> optional = lottoSettingService.validateInput(validator, inputSupplier, errorMessage);
            // then
            assertThat(optional.get()).isEqualTo("VALID");
        }
    }

    @Nested
    @DisplayName("입력값 반환 검증")
    class select {
        @DisplayName("올바른 구입 금액 입력시 Integer로 변환된 금액 반환")
        @Test
        void success_SelectPurchaseAmount() {
            // give
            LottoSettingService lottoSettingService = new LottoSettingService();
            PurchaseAmountValidator validator = new PurchaseAmountValidator();
            Supplier<String> inputSupplier = () -> "6000";
            Runnable requestMessage = () -> {};
            Consumer<String> errorConsumer = e -> {};
            // when
            int amount = lottoSettingService.selectPurchaseAmount(validator, inputSupplier, requestMessage, errorConsumer);
            // then
            assertThat(amount).isEqualTo(6000);
        }

        @DisplayName("올바른 정답 로또 번호 입력시 정답 로또 번호를 리스트로 반환")
        @Test
        void success_SelectWinningNumbers() {
            // give
            LottoSettingService lottoSettingService = new LottoSettingService();
            WinningLottoValidator validator = new WinningLottoValidator();
            Supplier<String> inputSupplier = () -> "1,2,3,4,5,6";
            Runnable requestMessage = () -> {};
            Consumer<String> errorConsumer = e -> {};
            List<Integer> testNumbers = List.of(1,2,3,4,5,6);
            // when
            List<Integer> winningNumbers = lottoSettingService.selectWinningNumbers(validator, inputSupplier, requestMessage, errorConsumer);
            // then
            assertThat(winningNumbers).isEqualTo(testNumbers);
        }

        @DisplayName("올바른 정답 로또 번호 입력시 정답 로또 번호를 리스트로 반환")
        @Test
        void success_SelectBonusNumber() {
            // give
            LottoSettingService lottoSettingService = new LottoSettingService();
            BonusNumberValidator validator = new BonusNumberValidator();
            Supplier<String> inputSupplier = () -> "10";
            Runnable requestMessage = () -> {};
            Consumer<String> errorConsumer = e -> {};
            // when
            int bonusNumber = lottoSettingService.selectBonusNumber(validator, inputSupplier, requestMessage, errorConsumer);
            // then
            assertThat(bonusNumber).isEqualTo(10);
        }
    }
}